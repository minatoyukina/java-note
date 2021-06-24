package leetcode._951__1000._984;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(strWithout3a3b(1, 2));
        System.out.println(strWithout3a3b(4, 1));
    }

    private String strWithout3a3b(int a, int b) {
        set = new HashSet<>();
        dfs(a, b, "");
        return x;
    }

    private String x;

    private Set<String> set;

    private void dfs(int a, int b, String pre) {
        String key = a + "," + b + pre;
        if (set.contains(key)) return;
        set.add(key);
        if (a < 0 || b < 0) return;
        if (a == 0 && b == 0) {
            x = pre;
            return;
        }
        if (!pre.startsWith("aa")) dfs(a - 1, b, "a" + pre);
        if (!pre.startsWith("bb")) dfs(a, b - 1, "b" + pre);
    }

}