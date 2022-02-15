package leetcode._1601__1650._1638;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countSubstrings("aba", "baba"));
        System.out.println(countSubstrings("ab", "bb"));
    }

    public int countSubstrings(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String ss = s.substring(i, j);
                count += sub(ss, t);
            }
        }
        return count;
    }

    public int sub(String s, String t) {
        int count = 0;
        for (int i = 0; i <= t.length() - s.length(); i++) {
            String tt = t.substring(i, i + s.length());
            if (check(s, tt)) count++;
        }
        return count;
    }

    private boolean check(String ss, String tt) {
        int diff = 0;
        for (int i = 0; i < ss.length(); i++) {
            if (ss.charAt(i) != tt.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }


}