package leetcode._1201__1250._1218;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestSubsequence(new int[]{1, 2, 3, 5, 6, 7}, 2));
    }

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length, max = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int pre = arr[i] - difference;
            dp[i] = map.containsKey(pre) ? (dp[map.get(pre)] + 1) : 1;
            max = Math.max(max, dp[i]);
            map.put(arr[i], i);
        }
        return max;
    }
}