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
    Condition isFull = lock.newCondition();
    Condition isEmpty = lock.newCondition();

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean add(T value) {
        lock.lock();
        try {
            if (value == null)
                throw new NullPointerException("The element must not be null");
            if (queue.size() < capacity)
                return queue.add(value);
            else
                throw new IllegalStateException("No space is currently available");
        } finally {
            lock.unlock();
        }

    }

    @Override
    public boolean offer(T value) {
        lock.lock();
        try {
            if (value == null)
                throw new NullPointerException("The element must not be null");
            if (queue.size() >= capacity) return false;
            queue.add(value);
            return true;
        } finally {
            lock.unlock();
        }

    }

    @Override
    public void put(T value) {
        if (value == null)
            throw new NullPointerException("The element must not be null");
        lock.lock();
        try {
            if (queue.size() >= capacity) {
                isFull.await();
            }
            queue.add(value);
            isEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public T remove() {
        lock.lock();
        try {
            if (queue.size() == 0)
                throw new NoSuchElementException("Collection is empty");
            return queue.remove(0);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean remove(Object o) {
        lock.lock();
        try {
            if (o == null)
                throw new NullPointerException("The element must not be null");
            return queue.remove(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public synchronized boolean offer(Object o, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public T take() {
        T result = null;
        lock.lock();
        try {
            if (queue.size() < 1) {
                isEmpty.await();
            }
            result = queue.remove(0);
            isFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return result;
    }

    @Override
    public synchronized T poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public T poll() {
        lock.lock();
        try {
            return (queue.size() != 0) ? queue.remove(0) : null;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int remainingCapacity() {
        lock.lock();
        try {
            return capacity - queue.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public T element() {
        lock.lock();
        try {
            if (queue.size() != 0)
                return queue.get(0);
            else
                throw new NoSuchElementException();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public T peek() {
        lock.lock();
        try {
            return (queue.size() != 0) ? queue.get(0) : null;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        try {
            return queue.isEmpty();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public synchronized boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        lock.lock();
        try {
            queue.clear();
        } finally {
            lock.unlock();
        }
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
    public boolean contains(Object o) {
        lock.lock();
        try {
            return queue.contains(o);
        } finally {
            lock.unlock();
        }
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
