package com.tibbo.datatable.util;

import com.tibbo.datatable.ValidationException;

import java.io.Serializable;
import java.security.KeyPair;
import java.util.*;

public class MultiMap<K,V> implements Cloneable, Serializable {

    public List<K> keys() {
        List<K> list = new LinkedList<K>();
        table.forEach(p -> {
            if(!list.contains(p.key))list.add( p.key );
        });
        return list;
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

    static class Pair<K, V> {
        K key;
        V value;
        Pair( K key, V value) {
            this.key = key;
            this.value = value;
        }
        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Pair) {
                Pair<?,?> e = (Pair<?,?>)o;
                if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }

    transient LinkedList<Pair<K,V>> table = new LinkedList<>();

    public int size() {
        return table.size();
    }

    public boolean isEmpty() {
        return table.isEmpty();
    }

    public List<V> get(Object key) {
        List<V> list = new LinkedList<V>();
        table.forEach( p -> {
            if( key.equals( p.key ) ) list.add( p.value );
        } );
        return list;
    }

    public V put(K key, V value) {
        Pair<K,V> pair = new Pair<K,V>(key,value);
        table.add(pair);
        return value;
    }

    public void putAll(List<Pair<K,V>> lists) {
        table.addAll(lists);
    }

    public void remove(K key) {
        table.removeIf( f -> f.key.equals(key));
    }
}
