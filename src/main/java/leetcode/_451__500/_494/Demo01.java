package leetcode._451__500._494;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 1));
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 5));
    }

    private int findTargetSumWays(int[] nums, int S) {
        int sum = 0, ans = 0;
        for (int num : nums) sum += num;
        if (sum < S) return 0;
        if (sum == S) return 1;
        for (int i = 0; i < nums.length; i++) {
            int x = sum;
            for (int j = i; j < nums.length; j++) {
                x = x - 2 * nums[j];
                if (x < S) break;
                else if (x == S) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

}
