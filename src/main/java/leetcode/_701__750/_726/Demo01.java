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
        System.out.println(countOfAtoms("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"));
        System.out.println(countOfAtoms("Mg(OH)2"));
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
    }

    private Map<Integer, Integer> match(String s) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            if (s.charAt(i) == ')') map.put(stack.pop(), i);
        }
        return map;
    }

    private Map<String, Integer> helper(Map<String, Integer> map, String s, Map<Integer, Integer> match, int begin, int end) {
        if (end > s.length() || begin >= end) return map;
        if (s.charAt(begin) == '(') {
            int right = match.get(begin);
            int y = right + 1;
            while (y < s.length() && s.charAt(y) >= '0' && s.charAt(y) <= '9') y++;
            int i = y == right + 1 ? 1 : Integer.parseInt(s.substring(right + 1, y));
            Map<String, Integer> helper = helper(map, s, match, begin + 1, right);
            for (Map.Entry<String, Integer> entry : helper.entrySet()) {
                map.put(entry.getKey(), entry.getValue() * i);
            }
            return helper(map, s, match, right, end);
        } else {
            for (int i = begin; i < end; i++) {
                if (s.charAt(i) == '(') return helper(map, s, match, i, end);
                int x = i;
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

    private String countOfAtoms(String formula) {
        return helper(new HashMap<>(), formula, match(formula), 0, formula.length()).entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(x -> x.getKey() + (x.getValue() == 1 ? "" : x.getValue()))
                .collect(Collectors.joining());
    }

}