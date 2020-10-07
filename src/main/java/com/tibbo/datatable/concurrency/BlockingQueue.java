package com.tibbo.datatable.concurrency;

import java.util.*;

public class BlockingQueue{

    private volatile LinkedList data;
    private Integer maxSize;

    public BlockingQueue(int maxSize){
        data = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public BlockingQueue(){
        this(Integer.MAX_VALUE);
    }

    public boolean offer(Object element){
        if(data.size() >= maxSize)
            return false;
        return data.offer(element);
    }

    public Object poll(){
        return data.poll(); //"poll()" will return 'null', if it's LinkedList is empty
    }

    public Object peek(){
        return data.peek(); //"peek()" will return 'null', if it's LinkedList is empty
    }

    public int size(){
        return data.size();
    }
}
