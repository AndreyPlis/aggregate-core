package com.tibbo.datatable.multiMap;

import java.util.*;

public class MapValue<K, V> {
    private K key;
    private List<V> values;

    public MapValue(K key){
        this.key = key;
        this.values = new LinkedList<>();
    }

    public MapValue(K key, V value){
        this(key);
        values.add(value);
    }

    public void addValue(V value){
        values.add(value);
    }

    public boolean removeValue(V value){
        if(values.contains(value))
            return values.remove(value);
        return false;
    }

    public boolean removeValue(int index){
        if(index >= 0 && values.size() > index) {
            values.remove(index);
            return true;
        }
        return false;
    }

    public V getValue(int index){
        if(index >= 0 && values.size() > index){
            return values.get(index);
        }
        return null;
    }

    public List<V>  getValuesList(){
        return values;
    }

    public int getSize(){
        return values.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapValue<?, ?> mapValue = (MapValue<?, ?>) o;
        return key.equals(mapValue.key) &&
                values.equals(mapValue.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, values);
    }
}
