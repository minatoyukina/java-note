package leetcode._1951__2000._1974;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minTimeToType("abc"));
        System.out.println(minTimeToType("zjpc"));
    }

    public int minTimeToType(String word) {
        char[] chars = word.toCharArray();
        char cur = 'a';
        int ans = 0;
        for (char c : chars) {
            int offset = Math.abs(c - cur);
            ans += (offset > 13 ? (26 - offset) : offset) + 1;
            cur = c;
        }
        return ans;
    }
}