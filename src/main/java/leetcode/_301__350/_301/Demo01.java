package leetcode._301__350._301;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(removeInvalidParentheses("a("));
        System.out.println(removeInvalidParentheses("()())()"));
        System.out.println(removeInvalidParentheses("(a)())()"));
    }

    private Set<String> set = new HashSet<>();

    private List<String> removeInvalidParentheses(String s) {
        dfs(s, 0, 0, "");
        long count = set.stream().mapToInt(String::length).max().orElse(0);
        return set.stream().filter(x -> x.length() == count).collect(Collectors.toList());
    }

    private void dfs(String s, int index, int n, String app) {
        if (index >= s.length()) {
            if (n == 0) set.add(app);
            return;
        }
        char c = s.charAt(index);
        if (c == '(' || c == ')') dfs(s, index + 1, n, app);
        if (n == 0 && c != ')') dfs(s, index + 1, c == '(' ? n + 1 : n, app + c);
        if (n > 0) {
            if (c == '(') dfs(s, index + 1, n + 1, app + c);
            else dfs(s, index + 1, c == ')' ? n - 1 : n, app + c);
        }
    }


}