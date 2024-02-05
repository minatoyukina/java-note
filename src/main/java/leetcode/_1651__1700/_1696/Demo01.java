package leetcode._1651__1700._1696;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
    }

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> last = tree.lastEntry();
            if (last != null) dp[i] += nums[i] + last.getKey();
            else dp[i] = nums[i];
            if (i - k >= 0) {
                if (tree.get(dp[i - k]) == 1) tree.remove(dp[i - k]);
                else tree.compute(dp[i - k], (x, y) -> y == null ? 0 : (y - 1));
            }
            tree.put(dp[i], tree.getOrDefault(dp[i], 0) + 1);
        }
        return dp[n - 1];
    }

}