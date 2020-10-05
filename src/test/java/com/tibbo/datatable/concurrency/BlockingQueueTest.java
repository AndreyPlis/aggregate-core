package com.tibbo.datatable.concurrency;

import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;

public class BlockingQueueTest extends TestCase {

    public void testPush() throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for(int i =0 ; i< 10; i++){
                    blockingQueue.push(i);
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for(int i =30 ; i< 40; i++){
                    blockingQueue.push(i);
                }
            }
        };

        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                for(int i =100 ; i< 110; i++){
                    blockingQueue.push(i);
                }
            }
        };
        Runnable r4 = new Runnable() {
            @Override
            public void run() {
                for(int i =0 ; i< 15; i++){
                    blockingQueue.get();
                }
            }
        };
        Runnable r5 = new Runnable() {
            @Override
            public void run() {
                for(int i =0 ; i< 15; i++){
                    blockingQueue.get();
                }
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        Thread t5 = new Thread(r5);

        t4.start();
        t5.start();
        Thread.sleep(2000L);
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();



        int a = 7;
        a++;// for point stop
        assertEquals(0, blockingQueue.getActualSize());

    }
}