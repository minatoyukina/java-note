package leetcode._1001__1050._1011;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }

    private int shipWithinDays(int[] weights, int D) {
        int sum = 0, max = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
            sum += weight;
        }
        int ans = sum;
        label:
        for (int i = max * weights.length / D; i >= sum / D; i--) {
            int count = 0, carry = 0;
            for (int j = 0; j < weights.length; j++) {
                if (weights[j] > i) continue label;
                if (carry + weights[j] <= i) {
                    carry += weights[j];
                    if (j == weights.length - 1) count++;
                } else {
                    carry = 0;
                    j--;
                    count++;
                }
                if (j == weights.length - 1) {
                    if (count <= D) ans = i;
                    else break label;
                }
            }
        }
        return ans;
    }

}