package leetcode._701__750._740;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4, 6, 7}));
    }

    private int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] dp = new int[max + 4];
        int ans = 0;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = map.getOrDefault(i - 3, 0) * (i - 3) + Math.max(dp[i - 2], dp[i - 3]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


}
