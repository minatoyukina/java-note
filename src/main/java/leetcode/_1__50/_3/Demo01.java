package leetcode._1__50._3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abc"));
        System.out.println(lengthOfLongestSubstring("aaa"));
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
}
