package leetcode._451__500._477;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(totalHammingDistance(new int[]{4, 14, 2}));
    }

    private int totalHammingDistance(int[] nums) {
        int count = 0;
        int[] arr = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num >> i & 1) == 1) arr[i]++;
            }
        }
        for (int i : arr) {
            count += i * (nums.length - i);
        }
        return count;
    }

}