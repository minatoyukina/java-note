package leetcode._701__750._720;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }

    private String longestWord(String[] words) {
        String ans = "";
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                String s = word.substring(0, word.length() - i);
                if (!set.contains(s)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (word.length() > ans.length()) ans = word;
                if (word.length() == ans.length() && word.compareTo(ans) < 0) ans = word;
            }
        }
        return ans;
    }

}