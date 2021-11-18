package leetcode._501__550._522;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findLUSlength(new String[]{"aabbcc", "aabbcc", "cb"}));
        System.out.println(findLUSlength(new String[]{"aaa", "aaa", "aa"}));
    }

    public int findLUSlength(String[] strs) {
        int max = -1;
        label:
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (check(strs[i], strs[j])) continue label;
            }
            max = Math.max(max, strs[i].length());
        }
        return max;
    }

    private boolean check(String a, String b) {
        int x = 0, y = 0;
        label:
        while (x < a.length() && y < b.length()) {
            while (a.charAt(x) != b.charAt(y)) if (++y >= b.length()) break label;
            x++;
            y++;
        }
        return x >= a.length();
    }
}