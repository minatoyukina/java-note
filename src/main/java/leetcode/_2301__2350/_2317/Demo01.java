package leetcode._2301__2350._2317;

import org.junit.Test;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(maximumXOR(new int[]{3, 2, 4, 6}));
    }


    private int maximumXOR(int[] nums) {
        int ans = 0;
        for (int num : nums) ans |= num;
        return ans;
    }

}
