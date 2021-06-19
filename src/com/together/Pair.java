package com.together;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class Pair<K,V>{

    private K key;
    private V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public Pair(){}

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setKeyValue(Object[] keyValue){
        setKey((K) keyValue[0]);
        setValue((V) keyValue[1]);
    }


    public void relocate(BiConsumer<K,V> biConsumer){
        biConsumer.accept(getKey(), getValue());
    }

    public static Pair<String, String> split(String regex, String data){
        String[] pairArray = data.split(regex);
        if(pairArray.length > 1){
            return new Pair<>(pairArray[0], pairArray[1]);
        }
        return null;
    }

    public static <K,V> ArrayList<Pair<K, V>> combine(K[] keys, V[] values) throws Exception {
        if(keys.length != values.length){
            throw new Exception("Incompatible array length can't combine arrays");
        }
        ArrayList<Pair<K,V>> pairs = new ArrayList<>();
        for (int i = 0; i < keys.length; i++) {
            pairs.add(new Pair<>(keys[i], values[i]));
        }
        return pairs;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}

