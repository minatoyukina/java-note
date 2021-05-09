package leetcode.lcci;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0809 {

    @Test
    public void test() {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(4));
    }

    private List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        dfs(1, "(", n, 1);
        return list;
    }

    private List<String> list;

    private void dfs(int left, String pre, int n, int remain) {
        if (left > n || remain < 0) return;
        if (pre.length() == 2 * n) {
            list.add(pre);
            return;
        }
        dfs(left + 1, pre + "(", n, remain + 1);
        dfs(left, pre + ")", n, remain - 1);
    }
}
