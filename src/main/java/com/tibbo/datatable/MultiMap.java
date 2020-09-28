package com.tibbo.datatable;

import java.util.ArrayList;
import java.util.Objects;

public class MultiMap<K, V> {
    final float  RELATIONSHIP = 0.75f;
    Node<K,V>[] hashTable = new Node[16];
    int actualSize = 0;
    int maxSize = 16;

    protected int getHash(K key){
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash^(hash>>>16);
    }

    public boolean put(K key, V value){
        actualSize++;
        if(actualSize / maxSize >= RELATIONSHIP){
            doublingHashTable();
        }
        Node<K, V> newNode = new Node<>(key, value);
        int index = getHash(key) % maxSize;
        if (hashTable[index]== null){
           hashTable[index]= newNode;
           return true;
        }
        Node<K, V> node = hashTable[index];
        if(newNode == node || newNode.equals(node)){
            return false;
        }
        while (node.nextNode!= null){
            node = node.getNextNode();
        }
        return node.setNextNode(newNode);
    }

    public ArrayList<V> get(K key){
        int index = getHash(key)% maxSize;
        ArrayList<V> list = new ArrayList<>();
        Node<K, V>  node = hashTable[index];
        while (node!= null){
            if(node.getKey().equals(key)) list.add(node.getValue());
            node = node.nextNode;
        }
        return list;
    }

    public   ArrayList<V> removeForKey(K key){
        int index = getHash(key)% maxSize;
        ArrayList<V> list = new ArrayList<>();
        if(hashTable[index]==null) return list;
        Node<K, V>  node = hashTable[index];
        Node<K, V>  prevNode = null;
        while (node!= null){
            if(node.getKey().equals(key)){
                list.add(node.getValue());
                if(prevNode == null){
                    hashTable[index] = hashTable[index].nextNode;
                    prevNode = null;
                }
                else {
                    prevNode.setNextNode(node.getNextNode());
                    prevNode = node;
                }
            }
            node = node.nextNode;
        }
        if(hashTable[index]==null) actualSize--;
        return list;
    }

    public void  clear(){
        actualSize=0;
        maxSize =16;
        hashTable = new Node[maxSize];
    }

    public ArrayList<V> putAllItTheList(){
        ArrayList<V> list = new ArrayList<>();
        for(int i = 0; i< maxSize; i++){
            if(hashTable!= null){
                Node<K, V> node = hashTable[i];
                while (node!= null){
                    list.add(node.getValue());
                    node = node.getNextNode();
                }
            }
        }
        return list;
    }

    private void doublingHashTable(){
        maxSize *=2;
        actualSize =0;
        Node<K,V>[] oldHashTable = hashTable;
        hashTable = new Node[maxSize];
        for(int i =0; i < oldHashTable.length; i++){
            Node<K,V> node = oldHashTable[i];
            while (node!= null){
                put(node.key, node.value);
                node = node.nextNode;
            }
        }
    }




    private static class Node<K, V>{
        K key;
        V value;
        Node<K,V> nextNode;

        private Node<K, V> getNextNode(){
            return nextNode;
        }

        private boolean setNextNode(Node<K, V> node){
            nextNode = node;
            return true;
        }

        private V getValue(){
            return  value;
        }

        private K getKey(){
            return key;
        }

        Node(K key, V value){
            this.key = key;
            this.value = value;
            nextNode = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return
                    Objects.equals(key, node.key) &&
                    Objects.equals(value, node.value) &&
                    Objects.equals(nextNode, node.nextNode);
        }

    }
}
