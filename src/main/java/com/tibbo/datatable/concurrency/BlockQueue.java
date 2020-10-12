package com.tibbo.datatable.concurrency;

import java.util.*;
import java.util.concurrent.locks.*;

public class BlockQueue {

    private LinkedList data;
    private Integer maxSize;
    /** The Lock usage taken from https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/Condition.html
     */
    final Lock lock = new ReentrantLock();
    final Condition notFull  = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    public BlockQueue(int maxSize){
        data = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public BlockQueue(){
        this(Integer.MAX_VALUE);
    }
/*
 class BoundedBuffer {
   final Lock lock = new ReentrantLock();
   final Condition notFull  = lock.newCondition();
   final Condition notEmpty = lock.newCondition();

   final Object[] items = new Object[100];
   int putptr, takeptr, count;

   public void put(Object x) throws InterruptedException {
     lock.lock();
     try {
       while (count == items.length)
         notFull.await();
       items[putptr] = x;
       if (++putptr == items.length) putptr = 0;
       ++count;
       notEmpty.signal();
     } finally {
       lock.unlock();
     }
   }

   public Object take() throws InterruptedException {
     lock.lock();
     try {
       while (count == 0)
         notEmpty.await();
       Object x = items[takeptr];
       if (++takeptr == items.length) takeptr = 0;
       --count;
       notFull.signal();
       return x;
     } finally {
       lock.unlock();
     }
   }
 }
 */
    public boolean offer(Object element){
        lock.lock();
        boolean result = false;
        try{
            while(data.size() >= maxSize) {
                System.out.println("There are not enough space. Offer is waiting.");
                notFull.await();
            }
            result = data.offer(element);
            notEmpty.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
        return result;
    }

    public Object poll(){
        lock.lock();
        Object result = null;
        try{
            while(data.size() == 0) {
                System.out.println("No data in the queue. Poll is waiting.");
                notEmpty.await();
            }
            result = data.poll();
            notFull.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return result;
    }

    public Object peek(){
        lock.lock();
        Object result = null;
        try{
            while(data.size() == 0)
                notEmpty.await();
            result = data.peek();
            notFull.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return result;
    }
}
