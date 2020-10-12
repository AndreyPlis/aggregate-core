package com.tibbo.datatable.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
    private Lock lock;
    private Condition condition;
    private final int MAXSIZE = 20;
    private int actualSize = 0;
    private Node<T> begin;
    private Node<T> end;

    public BlockingQueue(int actualSize, Node<T> newNode) {
        lock = new ReentrantLock();
        condition = lock.newCondition();
        this.actualSize = actualSize;
        this.begin = newNode;
        this.end = newNode;
    }

    public BlockingQueue(){
        this.actualSize = 0;
        this.begin = null;
        this.end = null;
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public  Node<T> getBegin() {
        Node<T> tmp = null;
        lock.lock();
        tmp = begin;
        lock.unlock();
        return tmp;
    }

    public Node<T> getEnd() {
        Node<T> tmp = null;
        lock.lock();
        tmp = end;
        lock.unlock();
        return tmp;
    }

    public int getMAXSIZE() {
        return MAXSIZE;
    }


    public int getActualSize() {
        int tmp = 0;
        lock.lock();
        tmp = actualSize;
        lock.unlock();
        return tmp;
    }

    public void setBegin(Node<T> begin) {
        lock.lock();
        this.begin = begin;
        lock.unlock();
    }

    public void setEnd(Node<T> end) {
        lock.lock();
        this.end = end;
        lock.unlock();
    }

    public void setActualSize(int actualSize) {
        lock.lock();
        this.actualSize = actualSize;
        lock.unlock();
    }


    public void push(T newValue) {
        lock.lock();
        try {
            while (actualSize >= MAXSIZE) {
                condition.await();
                }
            Node<T> tmp = new Node<T>(newValue, null);
            if(actualSize ==0){
                begin = tmp;
                end  = begin;
            }
            else {
                begin.setPrevNode(tmp);
                begin = tmp;
            }
            actualSize++;
            System.out.println("push" + newValue);
            condition.signalAll();
            }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        finally {
            lock.unlock();
        }
    }

     public T get(){
         T tmp = null;
         lock.lock();
         try {
             while (actualSize == 0) {
                 condition.await();
             }
             tmp = end.getValue();
             if (actualSize == 1) {
                 end = null;
                 begin = null;
             } else {
                 end = end.getPrevNode();
             }
             actualSize--;
             System.out.println("get" + tmp);
             condition.signal();
         }
         catch (InterruptedException e) {
             e.printStackTrace();
         }

         finally {
             lock.unlock();
            return tmp;
        }
     }
}
