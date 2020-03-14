package leetcode._27;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(removeElement(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 3));
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    private int removeElement(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] == val) {
                        continue;
                    }
                    int tmp;
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    break;
                }
            }
        }
        return Arrays.stream(nums).filter(x -> x != val).toArray().length;
    }
}
