package leetcode._701__750._726;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
        System.out.println(countOfAtoms("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"));
        System.out.println(countOfAtoms("Mg(OH)2"));
    }

    private String countOfAtoms(String formula) {
        Map<Integer, Integer> match = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '(') stack.push(i);
            if (formula.charAt(i) == ')') match.put(stack.pop(), i);
        }
        return helper(formula, match, 0, formula.length()).entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(x -> x.getKey() + (x.getValue() == 1 ? "" : x.getValue()))
                .collect(Collectors.joining());
    }

    private Map<String, Integer> merge(Map<String, Integer> m1, Map<String, Integer> m2) {
        for (Map.Entry<String, Integer> entry : m1.entrySet()) {
            String key = entry.getKey();
            m2.put(key, m2.getOrDefault(key, 0) + entry.getValue());
        }
        return m2;
    }

    private Map<String, Integer> helper(String s, Map<Integer, Integer> match, int begin, int end) {
        Map<String, Integer> map = new HashMap<>();
        if (end > s.length() || begin >= end) return map;
        if (s.charAt(begin) == '(') {
            int right = match.get(begin);
            int y = right + 1;
            while (y < s.length() && s.charAt(y) >= '0' && s.charAt(y) <= '9') y++;
            int count = y == right + 1 ? 1 : Integer.parseInt(s.substring(right + 1, y));
            Map<String, Integer> pre = helper(s, match, begin + 1, right);
            Map<String, Integer> next = helper(s, match, y, end);
            for (Map.Entry<String, Integer> entry : pre.entrySet()) {
                map.put(entry.getKey(), entry.getValue() * count);
            }
            return merge(map, next);
        }
        for (int i = begin; i < end; i++) {
            if (s.charAt(i) == '(') return merge(map, helper(s, match, i, end));
            int x = i + 1;
            while (x < end && s.charAt(x) >= 'a' && s.charAt(x) <= 'z') x++;
            String atom = s.substring(i, x);
            int y = x;
            while (y < end && s.charAt(y) >= '0' && s.charAt(y) <= '9') y++;
            map.put(atom, map.getOrDefault(atom, 0) + (y > x ? Integer.parseInt(s.substring(x, y)) : 1));
            i = y - 1;
        }
        return map;
    }
}