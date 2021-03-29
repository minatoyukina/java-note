package leetcode._51__100._60;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(4, 9));
    }

    private String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        while (n > 0) {
            int fac = fac(n - 1);
            int i = k % fac == 0 ? k / fac : k / fac + 1;
            sb.append(list.get(i - 1));
            list.remove(i - 1);
            k -= fac * (i - 1);
            n -= 1;
        }
        return sb.toString();
    }

    private int fac(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) res *= i;
        return res;
    }
}
