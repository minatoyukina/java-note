package leetcode._951__1000._974;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, -2));
    }


    private int subarraysDivByK(int[] A, int K) {
        int ans = 0, sum;
        for (int i = 0; i < A.length; i++) {
            sum = A[i];
            if (sum % K == 0) ans++;
            for (int j = i + 1; j < A.length; j++) {
                sum += A[j];
                if (sum % K == 0) ans++;
            }
        }
        return ans;
    }

}
