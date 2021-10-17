package leetcode._1001__1050._1013;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(canThreePartsEqualSum(new int[]{0, 0, 0, 0}));
    }

    private boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += i;
        if (sum % 3 != 0) return false;
        int pre = 0, count = 0;
        for (int x = 0; x < arr.length; x++) {
            int i = arr[x];
            pre += i;
            if (pre == sum / 3) {
                pre = 0;
                count++;
                if (count == 2 && x < arr.length - 1) return true;
            }
        }
        return count == 3;
    }

}