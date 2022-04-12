package leetcode._1451__1500._1477;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minSumOfLengths(new int[]{1, 1, 1, 2, 2, 2, 4, 4}, 6));
        System.out.println(minSumOfLengths(new int[]{7, 3, 4, 7}, 7));
    }

    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) pre[i] = pre[i - 1] + arr[i - 1];
        Map<Integer, Integer> visited = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < pre.length; i++) {
            int k = pre[i] - target;
            if (visited.containsKey(k)) list.add(new int[]{visited.get(k), i});
            visited.put(pre[i], i);
        }
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        list.sort(Comparator.comparingInt(x -> x[1]));
        for (int[] ints : list) {
            Map.Entry<Integer, Integer> entry = tree.floorEntry(ints[1]);
            if (entry == null) tree.put(ints[1], ints[1] - ints[0]);
            else tree.put(ints[1], Math.min(ints[1] - ints[0], entry.getValue()));
        }
        int ans = Integer.MAX_VALUE;
        for (int[] ints : list) {
            Map.Entry<Integer, Integer> entry = tree.floorEntry(ints[0]);
            if (entry != null) ans = Math.min(ans, ints[1] - ints[0] + entry.getValue());
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}