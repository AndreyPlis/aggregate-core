package com.tibbo.datatable.util;


import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
    private List<T> queue = new ArrayList<>();
    private int capacity = 10;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    private final Object monitor = new Object();

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(T value) {
        synchronized (monitor) {
            lock.lock();
            try {
                while (queue.size() >= capacity) {
                    condition.await();
                }
                queue.add(value);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void remove() {
        synchronized (this) {
            lock.lock();
            try {
                while (queue.size() < 1) {
                    condition.await();
                }
                queue.remove(0);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public T element() {
        if (queue.size() != 0)
            return queue.get(0);
        else
            throw new NoSuchElementException();
    }

    public T peek() {
        return (queue.size() != 0) ? queue.get(0) : null;
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean contains(T o) {
        return queue.contains(o);
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

    public T getElement() {
        return queue.get(0);
    }
}
