package leetcode._2251__2300._2270;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(waysToSplitArray(new int[]{2, 3, 1, 0}));

    }

    private int waysToSplitArray(int[] nums) {
        long sum = Arrays.stream(nums).mapToLong(Long::valueOf).sum(), pre = 0, cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            if (pre + num >= sum - num) cnt++;
            sum -= num;
            pre += num;
        }
        return (int) cnt;
    }


}
