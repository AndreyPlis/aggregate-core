import com.tibbo.datatable.util.BlockingQueue;
import com.tibbo.datatable.util.Consumers;
import com.tibbo.datatable.util.Producers;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class BlockingQueueTest {

    @Test(expected = NullPointerException.class)
    public void add() {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        blockingQueue.add(15);
        blockingQueue.add(17);
        assertEquals("[15, 17]", blockingQueue.toString());
        blockingQueue.add(null);

    }

    @Test()
    public void offer() {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        blockingQueue.offer(15);
        blockingQueue.offer(17);
        assertEquals("[15, 17]", blockingQueue.toString());
    }

    @Test
    public void remove() {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        blockingQueue.offer(15);
        blockingQueue.offer(17);
        assertEquals((Object) 15, blockingQueue.remove());
        assertTrue(blockingQueue.remove(17));
    }

    @Test
    public void poll() {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        assertNull(blockingQueue.poll());
        blockingQueue.offer(15);
        blockingQueue.offer(17);
        assertEquals((Object) 15, blockingQueue.poll());
    }

    @Test
    public void element() {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        blockingQueue.offer(15);
        blockingQueue.offer(17);
        assertEquals((Object) 15, blockingQueue.element());
        assertEquals("[15, 17]", blockingQueue.toString());
    }

    @Test
    public void peek() {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        assertNull(blockingQueue.peek());
        blockingQueue.offer(15);
        blockingQueue.offer(17);
        assertEquals((Object) 15, blockingQueue.peek());
        assertEquals("[15, 17]", blockingQueue.toString());
    }

    @Test
    public void take() {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Producers<Integer> prod = new Producers<>(blockingQueue, list);
        Consumers<Integer> cons = new Consumers<>(blockingQueue, list);
        Thread producers = new Thread(prod, "producersOne");
        Thread consumers = new Thread(cons, "consumersOne");

        consumers.start();
        producers.start();

        try {
            producers.join();
            consumers.join();
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("[]", blockingQueue.toString());
    }

    @Test
    public void put(){
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Producers<Integer> prod = new Producers<>(blockingQueue, list);
        Consumers<Integer> cons = new Consumers<>(blockingQueue, list);
        Thread producers = new Thread(prod, "producersOne");
        Thread consumers = new Thread(cons, "consumersOne");
        blockingQueue.setCapacity(4);
        blockingQueue.add(10);
        blockingQueue.add(11);
        blockingQueue.add(12);
        blockingQueue.add(13);
        producers.start();
        consumers.start();

        try {
            producers.join();
            consumers.join();
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("[12, 13, 1, 1]", blockingQueue.toString());
    }


    @Test
    public void queue() throws ExecutionException, InterruptedException {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Producers<Integer> prod = new Producers<>(blockingQueue, list);
        Consumers<Integer> cons = new Consumers<>(blockingQueue, list);
        CompletableFuture<Void> producer = CompletableFuture.runAsync(prod);
        CompletableFuture<Void> consumer = CompletableFuture.runAsync(cons);
        blockingQueue.setCapacity(2);
        blockingQueue.add(7);
        CompletableFuture.allOf(producer,consumer).thenAccept(v->{
            assertEquals("[1]",blockingQueue.toString());
            assertNotEquals("[2]",blockingQueue.toString());
        }).get();
    }

}
