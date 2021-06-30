package leetcode._1901__1950._1915;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(wonderfulSubstrings("fiabhedce"));
        System.out.println(wonderfulSubstrings("aabb"));
    }

    private long wonderfulSubstrings(String word) {
        boolean[][] pre = new boolean[word.length() + 1][10];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            pre[i + 1] = pre[i].clone();
            pre[i + 1][c - 'a'] = !pre[i][c - 'a'];
        }
        int ans = 0;
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < i; j++) {
                boolean[] x = pre[i];
                boolean[] y = pre[j];
                int count = 0;
                for (int k = 0; k < x.length; k++) {
                    if ((x[k] && !y[k]) || (!x[k] && y[k])) count++;
                }
                if (count <= 1) ans++;
            }
        }
        return ans;
    }

}