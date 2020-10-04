package com.tibbo.datatable.util;


import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> implements java.util.concurrent.BlockingQueue<T> {
    private List<T> queue = new ArrayList<>();
    private int capacity = 10;
    Lock lock = new ReentrantLock();
    Condition conditionPut = lock.newCondition();
    Condition conditionTake = lock.newCondition();

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public synchronized boolean add(T value) {
        if (value == null)
            throw new NullPointerException("The element must not be null");
        if (queue.size() < capacity)
            return queue.add(value);
        else
            throw new IllegalStateException("No space is currently available");
    }

    @Override
    public synchronized boolean offer(T value) {
        if (value == null)
            throw new NullPointerException("The element must not be null");
        if (queue.size() >= capacity) return false;
        queue.add(value);
        return true;
    }

    @Override
    public void put(T value) {
        if (value == null)
            throw new NullPointerException("The element must not be null");
        lock.lock();
        try {
            if (queue.size() >= capacity) {
                conditionPut.await();
            }
            queue.add(value);
            conditionTake.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public synchronized T remove() {
        if (queue.size() == 0)
            throw new NoSuchElementException("Collection is empty");
        return queue.remove(0);
    }

    @Override
    public synchronized boolean remove(Object o) {
        if (o == null)
            throw new NullPointerException("The element must not be null");
        return queue.remove(o);
    }

    @Override
    public synchronized boolean offer(Object o, long timeout, TimeUnit unit)  {
        return false;
    }

    @Override
    public T take() {
        T result = null;
        lock.lock();
        try {
            if (queue.size() < 1) {
                conditionTake.await();
            }
            result = queue.remove(0);
            conditionPut.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return result;
    }

    @Override
    public synchronized T poll(long timeout, TimeUnit unit)  {
        return null;
    }

    @Override
    public synchronized T poll() {
        return (queue.size() != 0) ? queue.remove(0) : null;
    }

    @Override
    public synchronized int remainingCapacity() {
        return capacity - queue.size();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlockingQueue<?> that = (BlockingQueue<?>) o;
        return capacity == that.capacity &&
                Objects.equals(queue, that.queue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queue, capacity);
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
