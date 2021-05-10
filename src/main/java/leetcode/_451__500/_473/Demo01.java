package leetcode._451__500._473;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {

    }

    private boolean makesquare(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;
        Arrays.sort(nums);
        int length = sum / 4;
        Set<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > length) return false;
        }
        return true;
    }


}