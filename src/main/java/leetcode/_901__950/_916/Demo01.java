package leetcode._901__950._916;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"ec", "oc", "ceo"}));
    }

    private List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        int[] a = new int[26];
        for (String s : words2) {
            int[] b = new int[26];
            for (char c : s.toCharArray()) b[c - 'a']++;
            for (int i = 0; i < a.length; i++) a[i] = Math.max(a[i], b[i]);
        }
        for (String s : words1) {
            int[] b = new int[26];
            for (char c : s.toCharArray()) b[c - 'a']++;
            boolean flag = true;
            for (int i = 0; i < a.length; i++) {
                if (b[i] < a[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) list.add(s);
        }
        return list;
    }

}