package leetcode._551__600._567;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(checkInclusion("abc", "bbbca"));
        System.out.println(checkInclusion("ky", "ainwkckifykxlribaypk"));
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ba", "eidbaoo"));
        System.out.println(checkInclusion("asc", "dcda"));
        System.out.println(checkInclusion("a", "ab"));
    }

    private boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.substring(0, s1.length()).toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : chars1) map1.merge(c, 1, (x, y) -> x + 1);
        for (char c : chars2) map2.merge(c, 1, (x, y) -> x + 1);
        map2.forEach((x, y) -> map2.put(x, y - map1.getOrDefault(x, 0)));
        map1.forEach((x, y) -> {
            if (!map2.containsKey(x)) map2.put(x, -y);
        });
        map2.values().removeIf(x -> x == 0);
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (map2.isEmpty()) return true;
            char a = s2.charAt(i);
            char b = s2.charAt(i + s1.length());
            map2.compute(a, (x, y) -> (y == null ? 0 : y) - 1);
            map2.merge(b, 1, (x, y) -> x + 1);
            if (map2.get(a) != null && map2.get(a) == 0) map2.remove(a);
            if (map2.get(b) != null && map2.get(b) == 0) map2.remove(b);
        }
        return map2.isEmpty();
    }

}
