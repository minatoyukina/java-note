package leetcode._351__400._385;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(deserialize("[123,[456,[789]]]"));
    }

    public NestedInteger deserialize(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') stack.add(i);
            if (c == ']') map.put(stack.pop(), i);
        }
        return dfs(s, map, 0, s.length() - 1);
    }

    private NestedInteger dfs(String s, Map<Integer, Integer> map, int left, int right) {
        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                Integer integer = map.get(i);
                dfs(s, map, i, integer);
            }
        }
        return new NestedInteger(Integer.parseInt(s));
    }

    @SuppressWarnings("all")
    static class NestedInteger {

        NestedInteger(int value) {

        }

        boolean isInteger() {
            return false;
        }

        Integer getInteger() {
            return 0;
        }

        void setInteger(int value) {
        }

        void add(NestedInteger ni) {
        }


        List<leetcode._301__350._341.NestedInteger> getList() {
            return null;
        }
    }

}