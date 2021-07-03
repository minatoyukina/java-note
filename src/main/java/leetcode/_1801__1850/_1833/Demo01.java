package leetcode._1801__1850._1833;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
        System.out.println(maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20));
    }

    private int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0, sum = 0;
        for (int cost : costs) {
            if (sum + cost <= coins) {
                ans++;
                sum += cost;
            } else break;
        }
        return ans;
    }

}