package com.tibbo.datatable.concurrency;

import java.util.Queue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class ProducerConsumer<T> {
    private static final int MAX_SIZE_QUEUE = 10;
    private final MyQueue<T> blockingQueue = new MyQueue<>( MAX_SIZE_QUEUE );

    public void produce(T value) throws InterruptedException {
        blockingQueue.put( value );
        System.out.println("SIZE :" + blockingQueue.size( ) );
    }
    public T consume() throws InterruptedException {
        T value = blockingQueue.take( );
        System.out.println("SIZE :" + blockingQueue.size( ) + " Value: " + value );
        return value;
    }
}