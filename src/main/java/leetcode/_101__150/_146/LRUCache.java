package leetcode._101__150._146;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Integer> map;
    private int capacity;

    public static void main(String... args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    private LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer integer = map.get(key);
        if (integer == null) return -1;
        map.remove(key);
        map.put(key, integer);
        return integer;
    }

    public void put(int key, int value) {
        if (map.size() == capacity) {
            if (map.containsKey(key)) {
                map.remove(key);
                map.put(key, value);
            } else {
                map.remove(map.keySet().iterator().next());
                map.put(key, value);
            }
        } else {
            if (map.containsKey(key)) {
                map.remove(key);
                map.put(key, value);
            } else map.put(key, value);
        }
    }
}
