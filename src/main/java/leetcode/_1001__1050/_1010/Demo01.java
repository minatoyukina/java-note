package leetcode._1001__1050._1010;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        System.out.println(numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }

    private int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : time) {
            int key = i % 60;
            if (!map.containsKey(key)) map.put(key, 1);
            else map.put(key, map.get(key) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (key < 30) res += entry.getValue() * map.getOrDefault(60 - key, 0);
        }
        Integer i = map.get(30);
        if (i != null && i > 1) res += i * (i - 1) / 2;
        Integer j = map.get(0);
        if (j != null && j > 1) res += j * (j - 1) / 2;
        return res;
    }
}
