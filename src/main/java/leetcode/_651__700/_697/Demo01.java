package leetcode._651__700._697;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }

    private int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int max = 0;
        for (Integer integer : map.values()) max = Math.max(max, integer);
        List<Integer> list = new ArrayList<>();
        int tmp = max;
        map.forEach((x, y) -> {
            if (y == tmp) list.add(x);
        });
        int min = nums.length;
        for (Integer integer : list) {
            int i = 0, j = nums.length - 1;
            while (nums[i] != integer) i++;
            while (nums[j] != integer) j--;
            min = Math.min(min, j - i + 1);
        }
        return min;
    }

}