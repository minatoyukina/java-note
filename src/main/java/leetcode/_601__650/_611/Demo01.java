package leetcode._601__650._611;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(triangleNumber(new int[]{2, 2, 3, 4}));
    }

    private int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int lo = 0, hi = i - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] > nums[i]) ans += hi-- - lo;
                else lo++;
            }
        }
        return ans;
    }


}
