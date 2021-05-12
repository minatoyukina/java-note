package leetcode._701__750._726;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countOfAtoms("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"));
        System.out.println(countOfAtoms("Mg(OH)2"));
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
    }

    private String countOfAtoms(String formula) {
        char[] chars = formula.toCharArray();
        List<Map<String, Integer>> list = new ArrayList<>();
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') left++;
            else if (c >= 'A' && c <= 'Z') {
                int x = i + 1;
                while (x < chars.length && chars[x] >= 'a' && chars[x] <= 'z') x++;
                String atom = formula.substring(i, x);
                int y = x;
                while (y < chars.length && chars[y] >= '0' && chars[y] <= '9') y++;
                while (list.size() <= left) list.add(new HashMap<>());
                Map<String, Integer> map = list.get(left);
                map.put(atom, map.getOrDefault(atom, 0) + (y > x ? Integer.parseInt(formula.substring(x, y)) : 1));
                i = y - 1;
            } else if (c == ')') {
                int y = i + 1;
                while (y < chars.length && chars[y] >= '0' && chars[y] <= '9') y++;
                for (int j = left; j < list.size(); j++) {
                    Map<String, Integer> map = list.get(j);
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        map.put(entry.getKey(), entry.getValue() * (y > i + 1 ? Integer.parseInt(formula.substring(i + 1, y)) : 1));
                    }
                }
                i = y - 1;
                left--;
            }
        }
        return list.stream().reduce(new HashMap<>(), (x, y) -> {
            x.forEach((a, b) -> y.put(a, y.getOrDefault(a, 0) + b));
            return y;
        }).entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(x -> x.getKey() + (x.getValue() == 1 ? "" : x.getValue()))
                .collect(Collectors.joining());
    }

}