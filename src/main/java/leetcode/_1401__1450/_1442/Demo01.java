package leetcode._1401__1450._1442;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println(countTriplets(new int[]{1, 1, 1, 1, 1}));
    }

    private int countTriplets(int[] arr) {
        int[] pre = new int[arr.length + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> t = new ArrayList<>();
        t.add(0);
        map.put(0, t);
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            pre[i + 1] = arr[i] ^ pre[i];
            List<Integer> list = map.getOrDefault(pre[i + 1], new ArrayList<>());
            for (int x : list) ans += i - x;
            list.add(i + 1);
            map.put(pre[i + 1], list);
        }
        return ans;
    }

}