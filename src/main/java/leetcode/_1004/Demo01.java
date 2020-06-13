package leetcode._1004;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    private int longestOnes(int[] A, int K) {
        int ans = 0, T = K;
        for (int i = 0; i < A.length; i++) {
            if (i >= 1 && A[i - 1] == 1 && A[i] == 1) continue;
            int tmp = 0;
            for (int j = i; j < A.length && T >= 0; j++) if ((A[j] == 0 && --T >= 0) || A[j] == 1) tmp++;
            ans = Math.max(ans, tmp);
            T = K;
        }
        return ans;
    }
}
