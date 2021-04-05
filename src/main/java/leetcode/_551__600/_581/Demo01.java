package leetcode._551__600._581;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 6, 10, 9, 15}));
    }

    private int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int i = 0, j = nums.length - 1;
        while (i < nums.length && nums[i] == copy[i]) i++;
        while (j >= 0 && nums[j] == copy[j]) j--;
        return i >= j ? 0 : j - i + 1;
    }

}