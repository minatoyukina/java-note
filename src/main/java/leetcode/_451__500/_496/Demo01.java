package leetcode._451__500._496;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    private int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int greater = -1;
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums2[j] > nums1[i]) greater = nums2[j];
                if (nums2[j] == nums1[i]) break;
            }
            ans[i] = greater;
        }
        return ans;
    }

}
