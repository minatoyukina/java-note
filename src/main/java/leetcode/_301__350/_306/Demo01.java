package leetcode._301__350._306;

import org.junit.Test;

import java.math.BigInteger;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(isAdditiveNumber("198019823962"));
        System.out.println(isAdditiveNumber("199100199"));
    }

    private boolean isAdditiveNumber(String num) {
        label:
        for (int i = 1; i < num.length() - 1; i++) {
            String s1 = num.substring(0, i);
            if (s1.startsWith("0") && s1.length() > 1) continue;
            BigInteger a = new BigInteger(s1);
            for (int j = i; j < num.length() - 1; j++) {
                String s2 = num.substring(i, j + 1);
                if (s2.startsWith("0") && s2.length() > 1) continue label;
                BigInteger b = new BigInteger(s2);
                if (dfs(a, b, num.substring(j + 1))) return true;
            }
        }
        return false;
    }

    private boolean dfs(BigInteger a, BigInteger b, String str) {
        if (str.isEmpty()) return true;
        BigInteger sum = a.add(b);
        String s = String.valueOf(sum);
        if (str.startsWith(s)) {
            return dfs(b, sum, str.replaceFirst(s, ""));
        }
        return false;
    }
}
