package com.tibbo.datatable.util;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Consumers<T> implements Runnable {
    BlockingQueue<T> queue;
    List<T> list;
    static Lock lock = new ReentrantLock();

    public Consumers(BlockingQueue<T> queue, List<T> list) {
        this.queue = queue;
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            queue.remove();
        }
    }
}
