package com.tibbo.datatable.util;

import java.util.*;

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
        for(int i=0;i<3;i++) {
            queue.put(list.get(0));
        }
    }
}
