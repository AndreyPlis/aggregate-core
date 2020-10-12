package com.tibbo.datatable.concurrency;

import junit.framework.TestCase;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BlockingQueueTest extends TestCase {

    public void testPush() throws InterruptedException {
        int countForPut1 = 60;
        int countForPut2 = 10;
        int countForPut3 = 10;
        int countForGet1 = 14;
        int countForGet2 = 60;
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for(int i =0 ; i< countForPut1; i++){
                    blockingQueue.push(i+10000);
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for(int i =0 ; i< countForPut2; i++){
                    blockingQueue.push(i+20);
                }
            }
        };

        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                for(int i =0 ; i< countForPut3; i++){
                    blockingQueue.push(i+100);
                }
            }
        };
        Runnable r4 = new Runnable() {
            @Override
            public void run() {
                for(int i =0 ; i< countForGet1; i++){
                    blockingQueue.get();
                }
            }
        };
        Runnable r5 = new Runnable() {
            @Override
            public void run() {
                for(int i =0 ; i< countForGet2; i++){
                    blockingQueue.get();
                }
            }
        };
        ThreadPoolExecutor poolForPush = new ThreadPoolExecutor(3, 5, 50, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));
        ThreadPoolExecutor poolForGet = new ThreadPoolExecutor(3, 5, 50, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));
       /* Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        Thread t5 = new Thread(r5);*/
        poolForPush.submit(r1);
        poolForPush.submit(r2);
        poolForPush.submit(r3);

        poolForGet.submit(r4);
        poolForGet.submit(r5);


      /*  t4.start();
        t5.start();
       Thread.sleep(2000L);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();*/


        Thread.sleep(2000L);
        poolForGet.shutdown();
        poolForPush.shutdown();

        assertEquals(countForPut1+ countForPut2+ countForPut3 - countForGet1 -countForGet2, blockingQueue.getActualSize());

    }
}