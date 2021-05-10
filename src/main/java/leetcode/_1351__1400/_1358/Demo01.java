package leetcode._1358;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstrings("cabbcbc"));
    }

    private int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Set<Character> set = new HashSet<>(6);
            int j = i;
            while (j < chars.length) {
                map.put(chars[j], j);
                set.add(chars[j++]);
                if (set.size() == 3) {
                    int x = map.get((char) ('a' + 'b' + 'c' - chars[j - 1] - chars[j - 2]));
                    ans += (x + 1 - i) * (chars.length - j + 1);
                    i = x;
                    break;
                }
            }
        }
        return ans;
    }
}
