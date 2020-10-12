package com.tibbo.datatable.concurrency;

import java.util.concurrent.*;

import com.tibbo.datatable.concurrency.*;
import com.tibbo.datatable.concurrency.BlockQueue;

public class QueueMain {
    public static void main(String[] args) {
        BlockQueue queue = new BlockQueue(5);

        ThreadPoolExecutor produce = new ThreadPoolExecutor(2, 4, 5,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(6, false) );

        ThreadPoolExecutor consume = new ThreadPoolExecutor(1, 2, 5,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(6, false) );

        produce.execute(new Producers(queue));
        produce.execute(new Producers(queue));
        consume.execute(new Consumers(queue));

        try {
            System.out.println("Main thread start waiting.");
            TimeUnit.SECONDS.sleep(10);
            System.out.println("Waiting of main thread completed.");
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        produce.shutdown();
        consume.shutdown();
        System.out.println("Main thread finished.");
    }
}
