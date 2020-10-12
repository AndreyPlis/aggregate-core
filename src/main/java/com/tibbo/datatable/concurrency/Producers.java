package com.tibbo.datatable.concurrency;

import java.util.concurrent.*;

public class Producers implements Runnable {
    private final BlockQueue queue;

    public Producers(BlockQueue queue){
        this.queue = queue;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            queue.offer(produce());
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    Object produce() {
        Double result = Math.random()*10;
        System.out.println(String.format("Producer: %1$s. In: %2$.3f",
                Thread.currentThread().getName(), result));
        return result;
    }
}
