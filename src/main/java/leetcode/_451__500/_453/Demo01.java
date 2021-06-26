package leetcode._451__500._453;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minMoves(new int[]{-100, 0, 100}));
    }


    private int minMoves(int[] nums) {
        int min = nums[0];
        for (int num : nums) min = Math.min(min, num);
        int sum = 0;
        for (int num : nums) sum += num - min;
        return sum;
    }

}
