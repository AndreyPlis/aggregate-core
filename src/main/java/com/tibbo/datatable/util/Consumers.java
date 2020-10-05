package com.tibbo.datatable.util;

import java.util.List;


public class Consumers<T> implements Runnable {
    BlockingQueue<T> queue;
    List<T> list;

    public Consumers(BlockingQueue<T> queue, List<T> list) {
        this.queue = queue;
        this.list = list;
    }

    @Override
    public void run() {
        for (int i=0;i<2;i++){
            queue.take();
        }
    }
}
