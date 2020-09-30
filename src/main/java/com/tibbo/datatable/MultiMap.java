package com.tibbo.datatable;

import java.util.*;

public class MultiMap<K, V> {

    private Map<K, Set<V>> data = new HashMap<>();

    public void put(K key, V value) {
        Set<V> res = data.get(key);
        if (res == null)
            res = new HashSet<>();

        res.add(value);
        data.put(key,res);
    }

    public boolean remove(K key, V value) {
        Set<V> res = data.get(key);
        if (res != null)
            return res.remove(value);
        return false;
    }

    public boolean contains(K key, V value) {
        Set<V> res = data.get(key);
        if (res != null)
            return res.contains(value);
        return false;
    }
}
