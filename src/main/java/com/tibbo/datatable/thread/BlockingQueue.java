package com.tibbo.datatable.thread;


import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> implements java.util.concurrent.BlockingQueue<T> {
    private List<T> queue = new ArrayList<>();
    private int maxCap = 10;
    Lock lock = new ReentrantLock();
    Condition condPut = lock.newCondition();
    Condition condTake = lock.newCondition();

    @Override
    public synchronized boolean add(T value) {
        if (value == null)
            throw new NullPointerException("The element cannot be null");
        if (queue.size() >= maxCap) {
            throw new IllegalStateException("There is no free space in the queue");
        }
        else {
            return queue.add(value);
        }
    }

    @Override
    public synchronized boolean offer(T value) {
        if (value == null)
            throw new NullPointerException("The element cannot be null");
        if (queue.size() >= maxCap) {
            return false;
        }
        queue.add(value);
        return true;
    }

    @Override
    public synchronized void put(T value) throws InterruptedException {
        if (value == null)
            throw new NullPointerException("The element cannot be null");
        lock.lock();
        try {
            if (queue.size() >= maxCap) {
                condPut.await();
            }
            queue.add(value);
            condTake.signal();
        } catch (InterruptedException e) {
            throw e;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public synchronized T remove() {
        if (queue.size() == 0)
            throw new NoSuchElementException("There are no items in the collection");
        return queue.remove(0);
    }

    @Override
    public synchronized boolean remove(Object o) {
        if (o == null)
            throw new NullPointerException("The element cannot be null");
        return queue.remove(o);
    }

    @Override
    public synchronized boolean offer(Object o, long timeout, TimeUnit unit) {
        return false;
    }

    @Override
    public synchronized T take() {
        T result = null;
        lock.lock();
        try {
            if (queue.size() < 1) {
                condTake.await();
            }
            result = queue.remove(0);
            condPut.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return result;
    }

    @Override
    public synchronized T poll(long timeout, TimeUnit unit) {
        return null;
    }

    public synchronized T poll() {
        if (queue.size() != 0) {
            return queue.remove(0);
        } else
            return null;
    }

    @Override
    public synchronized int remainingCapacity() {
        return maxCap - queue.size();
    }

    @Override
    public synchronized T element() {
        if (queue.size() != 0)
            return queue.get(0);
        else
            throw new NoSuchElementException();
    }

    @Override
    public synchronized T peek() {
        return (queue.size() != 0) ? queue.get(0) : null;
    }

    @Override
    public synchronized int size() {
        return queue.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public synchronized boolean addAll(Collection c) {
        return false;
    }

    @Override
    public synchronized void clear() {
        queue.clear();
    }

    @Override
    public synchronized boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public synchronized boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public synchronized boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public synchronized boolean contains(Object o) {
        return queue.contains(o);
    }

    @Override
    public synchronized Iterator iterator() {
        return null;
    }

    @Override
    public synchronized Object[] toArray() {
        return new Object[0];
    }

    @Override
    public synchronized Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public synchronized int drainTo(Collection c) {
        return 0;
    }

    @Override
    public synchronized int drainTo(Collection c, int maxElements) {
        return 0;
    }

    public int  getMaxCap() {
        return maxCap;
    }

    public void setMaxCap(int maxCap) {
        this.maxCap = maxCap;
    }
}