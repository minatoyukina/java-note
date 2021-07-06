package leetcode._801__850._819;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println(mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"}));
    }

    private String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        int left = -1;
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                if (left == -1) left = i;
            } else {
                if (left == -1) continue;
                String s = paragraph.substring(left, i).toLowerCase();
                if (!set.contains(s)) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                }
                left = -1;
            }
        }
        int max = 0;
        String ans = paragraph.toLowerCase();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                ans = entry.getKey();
                max = entry.getValue();
            }
        }
        return ans;
    }
}