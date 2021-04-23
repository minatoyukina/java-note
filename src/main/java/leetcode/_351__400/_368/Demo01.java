package leetcode._351__400._368;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(largestDivisibleSubset(new int[]{2, 3, 4, 9, 8}));
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }

    @SuppressWarnings("all")
    private List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer>[] dp = new List[nums.length];
        dp[0] = Collections.singletonList(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int offset = -1, max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j].size() > max) {
                    max = dp[j].size();
                    offset = j;
                }
            }
            if (offset >= 0) {
                List<Integer> list = new ArrayList<>(dp[offset]);
                list.add(nums[i]);
                dp[i] = list;
            } else dp[i] = Collections.singletonList(nums[i]);
        }
        int offset = 0, max = 0;
        for (int i = 0; i < dp.length; i++) {
            List<Integer> list = dp[i];
            if (list.size() > max) {
                max = list.size();
                offset = i;
            }
        }
        return dp[offset];
    }

}