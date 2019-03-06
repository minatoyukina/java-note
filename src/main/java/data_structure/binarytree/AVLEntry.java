package data_structure.binarytree;

import java.util.Map;

public class AVLEntry<K,V> implements Map.Entry<K,V> {
    public K key;
    public V value;
    public AVLEntry<K,V> left;
    public AVLEntry<K,V> right;

    public AVLEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "AVLEntry{" +
                "key=" + key +
                ", value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public K getKey() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }

    @Override
    public V setValue(V value) {
        return null;
    }
}
