package leetcode._2001__2050._2047;

import org.junit.Test;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(countValidWords(" o6 t"));
    }

    public int countValidWords(String sentence) {
        int count = 0;
        String[] split = sentence.trim().split("\\s+");
        label:
        for (String s : split) {
            if (s.lastIndexOf("-") != s.indexOf("-")) continue;
            if (s.contains("-")) {
                int x = s.indexOf("-");
                if (x == 0 || x == s.length() - 1) continue;
                char l = s.charAt(x - 1), r = s.charAt(x + 1);
                if (l - 'a' < 0 || l - 'z' > 0 || r - 'a' < 0 || r - 'z' > 0) continue;
            }
            int n = 0, flag = 1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c - '0' >= 0 && c - '9' <= 0) continue label;
                if (c == ',' || c == '!' || c == '.') n++;
                else if (i == s.length() - 1) flag = 0;
            }
            if (n > 1 || (n == 1 && flag == 0)) continue;
            count++;
        }
        return count;

    }

}
