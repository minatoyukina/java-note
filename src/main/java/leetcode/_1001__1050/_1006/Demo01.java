package leetcode._1001__1050._1006;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(clumsy(2));
        System.out.println(clumsy(10));
    }

    private int clumsy(int N) {
        int x = N;
        int ans = 0;
        while (x >= 4) {
            ans += (x == N ? 1 : -1) * x * (x - 1) / (x - 2) + (x - 3);
            x -= 4;
        }
        int odd = x == N ? -1 : 1;
        if (x == 3) ans += odd * -6;
        if (x == 2) ans += odd * -2;
        if (x == 1) ans += odd * -1;
        return ans;
    }

}