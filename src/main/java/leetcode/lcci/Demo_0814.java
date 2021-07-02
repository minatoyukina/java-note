package leetcode.lcci;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0814 {

    @Test
    public void test() {
        System.out.println(countEval("1|1|1^1^0^0^1|0&0^0&1&1|0|1^0|0", 0));
        System.out.println(countEval("0&0&0&1^1|0", 1));
    }

    private int countEval(String s, int result) {
        if (result != 0 && result != 1) return 0;
        map = new HashMap<>();
        int[] arr = dfs(s);
        return arr[result];
    }

    private Map<String, int[]> map;

    private int[] dfs(String s) {
        if (map.containsKey(s)) return map.get(s);
        int[] ans = new int[2];
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                flag = false;
                String s1 = s.substring(0, i);
                String s2 = s.substring(i + 1);
                int[] x = dfs(s1);
                int[] y = dfs(s2);
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        ans[compute(j, k, c)] += x[j] * y[k];
                    }
                }
            }
        }
        if (flag) ans[Integer.parseInt(s)]++;
        map.put(s, ans);
        return ans;
    }

    private int compute(int x, int y, char c) {
        if (c == '|') return x | y;
        if (c == '&') return x & y;
        return x ^ y;
    }
}
