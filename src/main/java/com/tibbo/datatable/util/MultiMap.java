package com.tibbo.datatable.util;

import com.tibbo.datatable.ValidationException;

import java.io.Serializable;
import java.security.KeyPair;
import java.util.*;

public class MultiMap<K,V> implements Cloneable, Serializable {

    public Set<K> keys() {
        return table.keySet( );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiMap<?, ?> multiMap = (MultiMap<?, ?>) o;
        return Objects.equals(table, multiMap.table);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table);
    }

    transient Map<K,Set<V>> table = new HashMap<>();

    public int size() {
        return table.size();
    }

    public boolean isEmpty() {
        return table.isEmpty();
    }

    public Set<V> get(K key) {
        return table.get( key );
    }

    public V put(K key, V value) {
        if( !table.containsKey( key ) ) {
            Set<V> var = new HashSet<>();
            var.add(value);
            table.put(key, var);
        }else {
            if (table.get(key).contains(value)) return null;
            table.get(key).add(value);
        }
        return value;
    }

    public void putAll(Map<K,Set<V>> lists) {
        table.putAll( lists );
    }

    public void remove(K key) {
        table.remove( key );
    }
}
