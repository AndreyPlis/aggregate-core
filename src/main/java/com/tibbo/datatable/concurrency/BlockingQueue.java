package com.tibbo.datatable.concurrency;

public class BlockingQueue<T> {
    private final int MAXSIZE = 20;
    private int actualSize = 0;
    Node<T> begin;
    Node<T> end;

    public BlockingQueue(int actualSize, Node<T> newNode) {
        this.actualSize = actualSize;
        this.begin = newNode;
        this.end = newNode;
    }

    public BlockingQueue(){
        this.actualSize = 0;
        this.begin = null;
        this.end = null;
    }

    public Node<T> getBegin() {
        return begin;
    }

    public Node<T> getEnd() {
        return end;
    }

    public int getMAXSIZE() {
        return MAXSIZE;
    }


    public int getActualSize() {
        return actualSize;
    }

    public void setBegin(Node<T> begin) {
        this.begin = begin;
    }

    public void setEnd(Node<T> end) {
        this.end = end;
    }

    public void setActualSize(int actualSize) {
        this.actualSize = actualSize;
    }


    public void push(T newValue) {
        synchronized (this) {
            while (actualSize >= MAXSIZE) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
            notify();
        }
    }

     public Node<T> get(){
        synchronized (this){
            while (actualSize ==0){
                try{
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Node<T> tmp = new Node<>();
            tmp = end;
            if(actualSize ==1){
               end = null;
               begin = null;
            }
            else {
                end = end.prevNode;
            }
            notify();
            actualSize--;
            return tmp;
        }
     }
}
