package leetcode._1401__1450._1413;

import org.junit.Test;

import java.util.stream.IntStream;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minStartValue(new int[]{-3, 2, -3, 4, 2}));
        System.out.println(minStartValue(new int[]{1, 2}));
    }

    public int minStartValue(int[] nums) {
        int left = 1, right = IntStream.of(nums).filter(x -> x < 0).sum() * -1 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean check(int target, int[] nums) {
        int sum = target;
        for (int num : nums) {
            sum += num;
            if (sum < 1) return false;
        }
        return true;
    }

}