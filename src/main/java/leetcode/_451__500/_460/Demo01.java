package leetcode._451__500._460;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        LFUCache lFUCache = new LFUCache(2);
        lFUCache.put(2, 1);
        lFUCache.put(1, 1);
        System.out.println(lFUCache.get(2));
        lFUCache.put(4, 1);
        System.out.println(lFUCache.get(1));
        System.out.println(lFUCache.get(2));


    }

    class LFUCache {

        private Map<Integer, Integer> map = new HashMap<>();
        private LinkedHashMap<Integer, Integer> countMap = new LinkedHashMap<>();
        private Map<Integer, Integer> stampMap = new HashMap<>();
        private int capacity;
        private int stamp;

        LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer integer = map.get(key);
            if (integer == null) return -1;
            countMap.put(key, countMap.get(key) + 1);
            stampMap.put(key, stamp++);
            return integer;
        }

        public void put(int key, int value) {
            if (capacity == 0) return;
            if (map.size() == capacity && !map.containsKey(key)) {
                int count = Integer.MAX_VALUE;
                int stamp = Integer.MAX_VALUE;
                int i = 0;
                for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                    Integer v = entry.getValue();
                    Integer k = entry.getKey();
                    if (v < count) {
                        count = v;
                        i = k;
                        stamp = stampMap.get(i);
                    }
                    if (v == count) {
                        if (stampMap.get(k) < stamp) {
                            count = v;
                            i = k;
                            stamp = stampMap.get(i);
                        }
                    }

                }
                countMap.remove(i);
                stampMap.remove(i);
                map.remove(i);
            }
            map.put(key, value);
            stampMap.put(key, stamp++);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }
    }

}