package leetcode._2551__2600._2559;

import leetcode.util.Common;
import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, Common.strToArray("[[0,2],[1,4],[1,1]]"))));
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] pre = new int[words.length + 1], ans = new int[queries.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i], s = "aeiou";
            pre[i + 1] = pre[i];
            if (s.contains(word.substring(0, 1)) && s.contains(word.substring(word.length() - 1))) pre[i + 1]++;
        }
        for (int i = 0; i < queries.length; i++) ans[i] = pre[queries[i][1] + 1] - pre[queries[i][0]];
        return ans;
    }

}