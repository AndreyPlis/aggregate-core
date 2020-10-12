package com.tibbo.datatable.concurrency;

import java.util.concurrent.*;

public class Consumers implements Runnable{
    private final BlockQueue queue;

    public Consumers(BlockQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            consume(queue.poll());
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    void consume(Object x) {
        if(x == null)
            System.out.println("Consume is null");
        else{
            if(x instanceof Number) {
                System.out.println(String.format("Consumer: %1$s.\tOut: %2$.3f",
                        Thread.currentThread().getName(), x) );
            }
            else{
                System.out.println("Consumer: " + Thread.currentThread().getName() + ".\tOut: " + x.toString());
            }
        }

    }
}
