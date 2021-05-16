package leetcode._401__450._421;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }

    private int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans = Math.max(ans, nums[i] ^ nums[j]);
            }
        }
        return ans;
    }

}