package leetcode._1951__2000._1995;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countQuadruplets(new int[]{28, 8, 49, 85, 37, 90, 20, 8}));
        System.out.println(countQuadruplets(new int[]{1, 1, 1, 3, 5}));
    }

    public int countQuadruplets(int[] nums) {
        int count = 0;
        for (int a = 0; a < nums.length; a++) {
            for (int b = 0; b < a; b++) {
                for (int c = 0; c < b; c++) {
                    for (int d = 0; d < c; d++) {
                        if (nums[a] == nums[b] + nums[c] + nums[d]) count++;
                    }
                }
            }
        }
        return count;
    }
}