package leetcode._451__500._474;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(findMaxForm(new String[]{"10", "1", "0"}, 1, 1));
        System.out.println(findMaxForm(new String[]{"111", "1000", "1000", "1000"}, 9, 3));
        System.out.println(findMaxForm(new String[]{"11111", "100", "1101", "1101", "11000"}, 5, 7));
    }

    private int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            char[] chars = strs[i - 1].toCharArray();
            int x = 0, y = 0;
            for (char c : chars) {
                if (c == '0') x++;
                else y++;
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j - x >= 0 && k - y >= 0) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - x][k - y] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

}
