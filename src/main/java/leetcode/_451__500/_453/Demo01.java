package leetcode._451__500._453;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minMoves(new int[]{-100, 0, 100}));
    }


    private int minMoves(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int min = nums[0];
        for (int i : nums) {
            min = Math.min(min, i);
        }
        long[] copy = new long[n];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = min < 0 ? nums[i] - min : nums[i];
        }
        long max = copy[0], mi = copy[0], sum = 0;
        for (long l : copy) {
            max = Math.max(max, l);
            mi = Math.min(mi, l);
            sum += l;
        }
        max = mi == max ? max : max + 1;
        while (true) {
            long y = max * n - sum;
            if (y % (n - 1) == 0) {
                return (int) (y / (n - 1));
            }
            max++;
        }
    }

}
