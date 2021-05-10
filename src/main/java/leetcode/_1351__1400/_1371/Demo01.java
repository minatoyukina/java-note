package leetcode._1371;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findTheLongestSubstring("id"));
        System.out.println(findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
        System.out.println(findTheLongestSubstring("bcbcbc"));
        System.out.println(findTheLongestSubstring("yopumzgd"));
        System.out.println(findTheLongestSubstring("janrudfu"));
    }

    private int findTheLongestSubstring(String s) {
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        char[] chars = s.toCharArray();
        int ans = 0;
        while (r < chars.length && l < chars.length) {
            Map<Character, Integer> copy = new HashMap<>(map);
            if (chars.length == 1 && copy.containsKey(chars[0])) return 0;
            for (int i = r; i < chars.length; i++) {
                if (copy.containsKey(chars[i])) copy.put(chars[i], copy.get(chars[i]) + 1);
                if (copy.values().stream().allMatch(x -> x % 2 == 0)) {
                    r = i + 1;
                    ans = Math.max(ans, r - l);
                    map = new HashMap<>(copy);
                }
            }
            Integer integer = map.get(chars[l]);
            if (integer != null && integer > 0) map.put(chars[l], integer - 1);
            l++;
            if (r < l) r = l;
        }
        return ans;
    }
}
