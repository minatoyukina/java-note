package leetcode._739;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    private int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int count = 0;
            ans[i] = count;
            for (int j = i + 1; j < T.length; j++) {
                count++;
                if (T[j] > T[i]) {
                    ans[i] = count;
                    break;
                }
            }
        }
        return ans;
    }

}
