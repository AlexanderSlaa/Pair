package Pair;

import java.util.function.BiConsumer;

public class Pair<K,V>{

    private K key;
    private V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

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

    @Override
    public String toString() {
        return key + "=" + value;
    }
}

