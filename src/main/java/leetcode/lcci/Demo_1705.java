package leetcode.lcci;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1705 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(findLongestSubarray(new String[]{
                "A", "1",})));
        System.out.println(Arrays.toString(findLongestSubarray2(new String[]{
                "A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6",
                "7", "H", "I", "J", "K", "L", "M"})));

    }

    private String[] findLongestSubarray(String[] array) {
        int m = array.length;
        int[][] dp = new int[m + 1][m + 1];
        int offset = 0, max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                char c = array[j].charAt(0);
                dp[i + 1][j + 1] = dp[i + 1][j] + (c >= '0' && c <= '9' ? 1 : -1);
                if (dp[i + 1][j + 1] == 0 && j - i > max) {
                    max = j - i + 1;
                    offset = i;
                }
            }
        }
        String[] ans = new String[max];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = array[offset++];
        }
        return ans;
    }

    private String[] findLongestSubarray2(String[] array) {
        int m = array.length;
        int[] sub = new int[m + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int offset = 0, max = 0;
        for (int i = 0; i < m; i++) {
            char c = array[i].charAt(0);
            sub[i + 1] = sub[i] + (c >= '0' && c <= '9' ? 1 : -1);
            Integer integer = map.get(sub[i + 1]);
            if (integer == null) map.put(sub[i + 1], i);
            else {
                if (i - integer > max) {
                    max = i - integer;
                    offset = integer + 1;
                }
            }
        }

        String[] ans = new String[max];
        for (int i = 0; i < ans.length; i++) ans[i] = array[offset++];
        return ans;
    }

}
