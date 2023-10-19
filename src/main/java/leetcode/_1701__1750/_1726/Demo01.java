package leetcode._1701__1750._1726;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(tupleSameProduct(new int[]{2, 3, 4, 6}));
        System.out.println(tupleSameProduct(new int[]{1, 2, 4, 5, 10}));
    }

    public int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.merge(nums[i] * nums[j], 1, (v1, v2) -> v1 + 1);
            }
        }
        return map.values().stream().map(x -> x * (x - 1) * 4).reduce(0, Integer::sum);
    }

}