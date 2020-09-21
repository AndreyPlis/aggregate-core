package com.tibbo.datatable.multiMap;

import java.util.*;

public class MultiMap<K, V> {
    private Map<K, MapValue<K,V>> data = new HashMap<>();

    public void put(K key, V value){
        if(data.containsKey(key)){
            MapValue<K, V> values = data.get(key);
            values.addValue(value);
            data.put(key, values);
        }
        else{
            data.put(key, new MapValue<>(key, value));
        }
    }

    public boolean removeValue(K key, V value){
        if(data.containsKey(key)){
            return data.get(key).removeValue(value);
        }
        return false;
    }

    public List<V> getValues(K key){
        if(data.containsKey(key))
            return data.get(key).getValuesList();
        return null;
    }

    public int getCount(K key){
        if(data.containsKey(key))
            return data.get(key).getSize();
        return 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiMap<?, ?> multiMap = (MultiMap<?, ?>) o;
        return data.equals(multiMap.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
