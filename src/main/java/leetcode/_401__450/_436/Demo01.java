package leetcode._401__450._436;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}})));
    }

    private int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) map.put(intervals[i][0], i);
        int[] ans = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            ans[i] = entry == null ? -1 : entry.getValue();
        }
        return ans;
    }

}