package com.tibbo.datatable.concurrency;

public class Producers implements Runnable {
    private final BlockingQueue queue;

    public Producers(BlockingQueue queue){
        this.queue = queue;
    }

    public void run() {
        boolean result = true;
        Object data = null;
        do {
            if(result)
                data = produce();
            synchronized (queue) {
                result = queue.offer(data);
                if (!result) {
                    try {
                        System.out.println(String.format("Queue is full. Producer %1$s  wait with %2$.3f value.",
                                Thread.currentThread().getName(), data));
                        queue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Producer " + Thread.currentThread().getName() + " was interrupted.");
                    }
                }
                else{
                    queue.notify();
                    /*try {
                        queue.wait(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
            }
        } while (!Thread.currentThread().isInterrupted());
    }

    Object produce() {
        Double result = Math.random()*10;
        System.out.println(String.format("Producer: %1$s. In: %2$.3f",
                Thread.currentThread().getName(), result));
        return result;
    }
}
