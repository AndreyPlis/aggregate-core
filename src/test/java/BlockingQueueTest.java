import com.tibbo.datatable.util.BlockingQueue;
import org.junit.*;

import static org.junit.Assert.*;

public class BlockingQueueTest {

    @Test()
    public void add() {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        blockingQueue.add(15);
        blockingQueue.add(17);
        assertEquals("[15, 17]", blockingQueue.toString());
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

}
