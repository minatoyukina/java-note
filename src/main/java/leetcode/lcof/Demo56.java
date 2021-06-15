package leetcode.lcof;

import org.junit.Test;

public class Demo56 {

    @Test
    public void test() {
        System.out.println(singleNumber(new int[]{3, 4, 3, 3}));
        System.out.println(singleNumber(new int[]{1, 2, 3, 2, 3, 3, 2}));
    }


    private int singleNumber(int[] nums) {
        int[] bits = new int[31];
        for (int i = 0; i < bits.length; i++) {
            for (int num : nums) {
                bits[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < bits.length; i++) {
            ans += (bits[i] % 3 == 0 ? 0 : 1) * Math.pow(2, i);
        }
        return ans;
    }
}
