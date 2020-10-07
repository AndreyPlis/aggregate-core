package com.tibbo.datatable.concurrency;

public class Consumers implements Runnable{
    private final BlockingQueue queue;

    public Consumers(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Object data = null;
        while(!Thread.currentThread().isInterrupted()) {
            synchronized (queue) {
                data = queue.poll();
                if(data == null) {
                    try {
                        System.out.println("Queue is empty. Consumer " + Thread.currentThread().getName() + " wait for new data.");
                        queue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Consumer " + Thread.currentThread().getName() + " was interrupted.");
                    }
                }
                else{
                    queue.notifyAll();
                    /*try {
                        queue.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
            }
            consume(data);
        }
    }

    void consume(Object x) {
        if(x == null)
            System.out.println("Consume is null");
        else{
            if(x instanceof Number) {
                System.out.println(String.format("Consumer: %1$s. Out: %2$.3f",
                        Thread.currentThread().getName(), x) );
            }
            else{
                System.out.println("Consumer: " + Thread.currentThread().getName() + ". Out: " + x.toString());
            }
        }

    }
}
