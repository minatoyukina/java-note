package leetcode._151__200._152;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4, 5}));
        System.out.println(maxProduct(new int[]{-2}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct(new int[]{-2, -3}));
    }

    private int maxProduct(int[] nums) {
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sub = nums[i], preProd = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                preProd *= nums[j];
                sub = Math.max(sub, preProd);
            }
            ans = Math.max(ans, sub);
        }
        return ans;
    }
}
