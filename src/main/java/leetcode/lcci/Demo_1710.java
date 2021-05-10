package leetcode.lcci;

import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1710 {

    @Test
    public void test() {
        System.out.println(majorityElement(new int[]{1, 2, 5, 5, 3, 4, 6, 7}));
    }

    private int majorityElement(int[] nums) {
        int res = -1, count = 0;
        for (int num : nums) {
            if (count == 0) res = num;
            if (num == res) count++;
            else count--;
        }
        count = 0;
        for (int num : nums) count += (res == num ? 1 : 0);
        return count > nums.length >> 1 ? res : -1;
    }

}
