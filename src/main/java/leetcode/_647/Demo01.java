package leetcode._647;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("fdsklf"));
    }

    private int countSubstrings(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ans = count(ans, chars, i, i);
        }
        for (int i = 0; i < chars.length - 1; i++) {
            int right = i + 1;
            ans = count(ans, chars, i, right);
        }
        return ans;
    }

    private int count(int ans, char[] chars, int left, int right) {
        while (left >= 0 && left < chars.length && right >= 0 && right < chars.length) {
            if (chars[left] == chars[right]) {
                ans++;
                left--;
                right++;
            } else break;

        }
        return ans;
    }


}
