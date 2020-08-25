package leetcode._401__450._424;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(characterReplacement("ABBB", 2));
        System.out.println(characterReplacement("ABAAA", 0));
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
        System.out.println(characterReplacement("ABAABACA", 3));
    }

    private int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int ans = 0, l = 0, r = 0, tmp = k;
        while (r < s.length()) {
            if (tmp > 0 || (tmp == 0 && chars[l] == chars[r])) {
                if (chars[l] != chars[r]) tmp--;
                map.put(chars[r], map.getOrDefault(chars[r], 0) + 1);
                r++;
                if (r == s.length()) ans = Math.max(ans, r - l + Math.min(tmp, l));
            } else {
                ans = Math.max(ans, r - l);
                if (l + 1 < chars.length) {
                    map.put(chars[l], map.get(chars[l]) - 1);
                    l++;
                    tmp = k - (r - l - map.getOrDefault(chars[l], 0));
                }
            }
        }
        return ans;
    }

}
