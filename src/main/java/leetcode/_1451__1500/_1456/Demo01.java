package leetcode._1451__1500._1456;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxVowels("weallloveyou", 7));
        System.out.println(maxVowels("leetcode", 8));
    }

    public int maxVowels(String s, int k) {
        int left = 0, right = 0, count = 0, max = 0;
        while (right < s.length()) {
            while (right < k) if (check(s.charAt(right++))) count++;
            if (k == s.length()) return count;
            max = Math.max(max, count);
            if (check(s.charAt(right++))) count++;
            if (check(s.charAt(left++))) count--;
            max = Math.max(max, count);
        }
        return max;
    }

    private boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}