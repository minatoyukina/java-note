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
        while (n != 0) {
            int helper = helper(n - 1);
            int i = k % helper == 0 ? k / helper : k / helper + 1;
            int s = list.get(i - 1);
            sb.append(s);
            list.remove(i - 1);
            k -= helper * (i - 1);
            n -= 1;
        }
        return sb.toString();
    }

    private int helper(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) res *= i;
        return res;
    }
}
