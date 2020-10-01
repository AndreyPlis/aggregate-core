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
        while (true) {
            int num = random.nextInt(9);
            queue.add(list.get(num));
        }
    }
}
