package leetcode._1701__1750._1711;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countPairs(new int[]{1, 3, 5, 7, 9}));
        System.out.println(countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));
    }

    private int countPairs(int[] deliciousness) {
        int[] arr = new int[22];
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) arr[i] = arr[i - 1] * 2;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, mod = (int) 1e9 + 7;
        for (int i : deliciousness) {
            ans += map.getOrDefault(i, 0);
            ans %= mod;
            for (int j : arr) map.put(j - i, map.getOrDefault(j - i, 0) + 1);
        }
        return ans;
    }

}