package leetcode._2701__2750._2746;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minimizeConcatenatedLength(new String[]{"aaa", "c", "aba"}));
    }

    public int minimizeConcatenatedLength(String[] words) {
        dp = new int[26][26][1000];
        for (int[][] ints : dp) for (int[] anInt : ints) Arrays.fill(anInt, -1);
        String s = words[0];
        return s.length() + dfs(s.charAt(0) - 'a', s.charAt(s.length() - 1) - 'a', 1, words);
    }

    int[][][] dp;

    private int dfs(int left, int right, int index, String[] words) {
        if (index >= words.length) return 0;
        if (dp[left][right][index] != -1) return dp[left][right][index];
        String word = words[index];
        int l = word.charAt(0) - 'a', r = word.charAt(word.length() - 1) - 'a';
        return dp[left][right][index] = Math.min(dfs(left, r, index + 1, words) + word.length() - (right == l ? 1 : 0),
                dfs(l, right, index + 1, words) + word.length() - (r == left ? 1 : 0));
    }

}