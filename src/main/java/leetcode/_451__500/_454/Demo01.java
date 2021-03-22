package leetcode._451__500._454;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }

    private int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : C) {
            for (int j : D) {
                int value = map.getOrDefault(0 - i - j, 0);
                map.put(0 - i - j, value + 1);
            }
        }
        int res = 0;
        for (int i : A) {
            for (int j : B) {
                res += map.getOrDefault(i + j, 0);
            }
        }
        return res;
    }

}