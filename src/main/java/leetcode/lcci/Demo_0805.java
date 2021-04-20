package leetcode.lcci;

import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0805 {

    @Test
    public void test() {
        System.out.println(multiply(1, 10));
        System.out.println(multiply(3, 4));
    }

    private int multiply(int A, int B) {
        if (B > A) {
            int t = A;
            A = B;
            B = t;
        }
        char[] chars = String.valueOf(B).toCharArray();
        int n = 0;
        int ans = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int x = chars[i] - '0';
            int sum = 0;
            for (int j = 0; j < x; j++) sum += A;
            StringBuilder sb = new StringBuilder();
            sb.append(sum);
            for (int j = 0; j < n; j++) sb.append(0);
            ans += Integer.parseInt(sb.toString());
            n++;
        }
        return ans;
    }
}
