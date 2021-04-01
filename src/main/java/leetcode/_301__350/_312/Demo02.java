package leetcode._301__350._312;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(maxCoins(new int[]{2, 3, 7, 9, 1, 8, 2}));
    }

    @SuppressWarnings("unchecked")
    private int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        Set[][] set = new Set[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (set[i][j] == null) set[i][j] = new HashSet();
                set[i][j].add(j);
                if (i == 0) {
                    int x = j - 1 < 0 ? 1 : nums[j - 1];
                    int y = j + 1 >= nums.length ? 1 : nums[j + 1];
                    dp[0][j] = x * y * nums[j];
                } else {
                    int max = 0, offset = 0;
                    for (int k = 0; k < dp[i - 1].length; k++) {
                        if (!set[i - 1][k].contains(j)) {
                            int left = j - 1, right = j + 1;
                            while (left >= 0 && set[i - 1][k].contains(left)) left--;
                            while (right < nums.length && set[i - 1][k].contains(right)) right++;
                            int tmp = (left < 0 ? 1 : nums[left])
                                    * (right >= nums.length ? 1 : nums[right])
                                    * nums[j] + dp[i - 1][k];
                            if (tmp > max) {
                                max = tmp;
                                offset = k;
                            }
                        }
                    }
                    dp[i][j] = max;
                    set[i][j].addAll(set[i - 1][offset]);
                }
            }
        }
        int max = 0;
        for (int i : dp[nums.length - 1]) max = Math.max(max, i);
        return max;
    }
}