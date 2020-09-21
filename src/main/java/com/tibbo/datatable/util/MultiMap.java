package com.tibbo.datatable.util;


import java.util.*;
import java.util.stream.Collectors;

public class MultiMap<K, V> {
    Map<K, Map<V, Object>> multimap = new HashMap<>();

    public int size() {
        return multimap.size();
    }

    public boolean isEmpty() {
        return multimap.isEmpty();
    }

    public void put(K key, V value) {
        if (multimap.containsKey(key)) {
            multimap.get(key).put(value, null);
        } else {
            Map<V, Object> valueMap = new HashMap<>();
            valueMap.put(value, null);
            multimap.put(key, valueMap);
        }

    }

    public List<V> get(K key) {
        return (containsKey(key)) ? new ArrayList<>(multimap.get(key).keySet()) : new ArrayList<>();
    }

    public boolean containsKey(K key) {
        return multimap.containsKey(key);
    }


    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public List<V> remove(K key) {
        return (containsKey(key)) ? new ArrayList<>(multimap.remove(key).keySet()) : new ArrayList<>();
    }

    public V remove(K key, V value) {
        return (multimap.get(key).remove(value, null)) ? value : null;
    }

    public void removeAll() {
        multimap.clear();
    }


    public boolean replace(K key, V oldValue, V newValue) {
        if (oldValue == remove(key, oldValue)) {
            put(key, newValue);
            return true;
        } else
            return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiMap<?, ?> multiMap = (MultiMap<?, ?>) o;
        return Objects.equals(multimap, multiMap.multimap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(multimap);
    }

    @Override
    public String toString() {
        return multimap.keySet().stream().map(e -> e + "=" + get(e) + "\n").collect(Collectors.joining());
    }
}
