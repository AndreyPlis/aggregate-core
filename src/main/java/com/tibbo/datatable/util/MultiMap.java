package com.tibbo.datatable.util;


import java.util.*;

public class MultiMap<K, V> {
    List<Node<K, V>> multiMapList = new LinkedList<>();

    private static class Node<K, V> {
        private final K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key) &&
                    Objects.equals(value, node.value);
        }
    }

    private Node<K, V> getNode(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        if (multiMapList.contains(node)) {
            for (Node<K, V> kvNode : multiMapList) {
                if (kvNode.equals(node))
                    return node;
            }
        }
        return null;
    }

    public int size() {
        return multiMapList.size();
    }

    public boolean isEmpty() {
        return multiMapList.isEmpty();
    }

    public boolean containsKey(K key) {
        for (Node<K, V> d : multiMapList) {
            if (d.getKey().equals(key))
                return true;
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (Node<K, V> d : multiMapList) {
            if (d.getValue().equals(value))
                return true;
        }
        return false;
    }

    public List<V> get(K key) {
        List<V> res = new ArrayList<>();
        if (containsKey(key))
            for (Node<K, V> d : multiMapList) {
                if (d.key.equals(key)) res.add(d.value);
            }
        return res;

    }

    public void put(K key, V value) {
        multiMapList.add(new Node<>(key, value));
    }

    public boolean remove(K key, V value) {
        if (getNode(key, value) != null) {
            return multiMapList.remove(getNode(key, value));
        }
        return false;
    }

    public void clear() {
        multiMapList.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiMap<?, ?> multiMap = (MultiMap<?, ?>) o;
        if (multiMapList.size() != multiMap.multiMapList.size())
            return false;
        for (int i = 0; i < multiMapList.size(); i++)
            if (!multiMapList.get(i).equals(multiMap.multiMapList.get(i)))
                return false;
        return Objects.equals(multiMapList, multiMap.multiMapList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(multiMapList);
    }

    @Override
    public String toString() {
        return "MultiMap{" +
                "list=" + multiMapList +
                '}';
    }

}
