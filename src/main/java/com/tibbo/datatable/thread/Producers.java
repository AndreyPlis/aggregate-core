package com.tibbo.datatable.thread;

import java.util.List;
import java.util.Random;

public class Producers<T> implements Runnable {
    BlockingQueue<T> queue;
    List<T> list;
    Random random = new Random();

    public Producers(BlockingQueue<T> queue, List<T> list) {
        this.queue = queue;
        this.list = list;
    }

    @Override
    public void run() {
        for(int i=0;i<2;i++) {
            queue.put(list.get(0));
        }
    }
}