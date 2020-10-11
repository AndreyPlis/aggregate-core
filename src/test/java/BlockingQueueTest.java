import com.tibbo.datatable.util.BlockingQueue;
import com.tibbo.datatable.util.Consumers;
import com.tibbo.datatable.util.Producers;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

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
        assertEquals("[1]", blockingQueue.toString());
    }

    @Test
    public void put() {
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
        producers.start();
        consumers.start();

        try {
            producers.join();
            consumers.join();
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("[12, 1, 1, 1]", blockingQueue.toString());
    }


    @Test(timeout = 100)
    public void queueTest1() throws ExecutionException, InterruptedException {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Producers<Integer> prod = new Producers<>(blockingQueue, list);
        Consumers<Integer> cons = new Consumers<>(blockingQueue, list);
        CompletableFuture<Void> producer = CompletableFuture.runAsync(prod);
        CompletableFuture<Void> consumer = CompletableFuture.runAsync(cons);
        blockingQueue.setCapacity(2);
        blockingQueue.add(7);
        CompletableFuture.allOf(producer, consumer).thenAccept(v -> {
            assertEquals("[1, 1]", blockingQueue.toString());
            assertNotEquals("[2]", blockingQueue.toString());
        }).join();

    }

    @Test(timeout = 100)
    public void queueTest2() {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 2, 3, 4));
        blockingQueue.setCapacity(2);
        blockingQueue.add(7);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 4, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        Producers<Integer> prod = new Producers<>(blockingQueue, list);
        Consumers<Integer> cons = new Consumers<>(blockingQueue, list);
        Future<?> futureProducers = pool.submit(prod);
        Future<?> futureConsumers = pool.submit(cons);
        try {
            futureConsumers.get();
            futureProducers.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();
        assertEquals("[3, 3]", blockingQueue.toString());
    }

    @Test(timeout = 100)
    public void threadSafeAdd() {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        blockingQueue.setCapacity(100);
        Random random = new Random();
        CountDownLatch latchThread = new CountDownLatch(1);
        CountDownLatch latchAssert = new CountDownLatch(100);
        Runnable addValue = () -> {
            try {
                latchThread.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            blockingQueue.add(random.nextInt());
            latchAssert.countDown();
        };
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(addValue);
        }
        latchThread.countDown();
        try {
            latchAssert.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        assertEquals(100, blockingQueue.size());
    }

    @Test
    public void testTakeBlocksWhenEmpty() {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        Runnable runnable = () -> {
            blockingQueue.take();
            fail();
        };
        try {
            Thread thread = new Thread(runnable);
            thread.start();
            thread.interrupt();
            thread.join();
        } catch (Exception unexpected) {
            fail();
        }
    }
}
