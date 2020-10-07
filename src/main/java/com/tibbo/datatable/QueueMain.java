package com.tibbo.datatable;

import com.tibbo.datatable.concurrency.*;

public class QueueMain {
    public static void main(String[] args) {
        Object obj = new Object();
        BlockingQueue queue = new BlockingQueue(5);
        Producers p1 = new Producers(queue);
        Producers p2 = new Producers(queue);
        Consumers c1 = new Consumers(queue);

        Thread thP1 = new Thread(p1);
        Thread thP2 = new Thread(p2);
        Thread thC1 = new Thread(c1);
        thP1.start();
        thP2.start();
        thC1.start();
        synchronized (obj) {
            try {
                System.out.println("Main thread start waiting.");
                //obj.wait(2000);
                Thread.sleep(2000);
                System.out.println("Waiting of main thread completed.");
            } catch (InterruptedException e) {
                System.out.println("Main thread was interrupted.");
            }
        }
        thP1.interrupt();
        thP2.interrupt();
        thC1.interrupt();
        System.out.println("Main thread finished.");
    }
}
