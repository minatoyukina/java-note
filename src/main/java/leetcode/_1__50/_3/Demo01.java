package leetcode._1__50._3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abc"));
        System.out.println(lengthOfLongestSubstring("aaa"));

        System.out.println(lengthOfLongestSubstring1("abc"));
        System.out.println(lengthOfLongestSubstring1("aaa"));
    }

    private int lengthOfLongestSubstring(String s) {
        List<Integer> list = new ArrayList<>();
        cutAndSum(list, s);
        return list.stream().max(Integer::compareTo).orElse(1);
    }

    private void cutAndSum(List<Integer> list, String s) {
        if (s.length() >= 2) {
            char first = s.charAt(0);
            List<Character> characterList = new ArrayList<>();
            characterList.add(first);
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!characterList.contains(c)) {
                    characterList.add(c);
                } else {
                    break;
                }
            }
            list.add(characterList.size());
            cutAndSum(list, s.substring(1));
        } else if (s.isEmpty()) {
            list.add(0);
        }
    }

    private int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, ans = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) start = Math.max(map.get(c) + 1, start);
            ans = Math.max(ans, end - start + 1);
            map.put(c, end++);
        }
        return ans;
    }
}
