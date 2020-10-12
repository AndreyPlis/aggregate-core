package com.tibbo.datatable.concurrency;

public class Node<T> {
    private T value;
    private Node<T> prevNode;

    public Node(){
        this.value = null;
        this.prevNode = null;
    }

    public Node(T value, Node<T> prevNode) {
        this.value = value;
        this.prevNode = prevNode;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getPrevNode() {
        return prevNode;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setPrevNode(Node<T> prevNode) {
        this.prevNode = prevNode;
    }
}
