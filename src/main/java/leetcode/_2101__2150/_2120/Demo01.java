package leetcode._2101__2150._2120;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(executeInstructions(3, new int[]{0, 1}, "RRDDLU")));
    }

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int x = startPos[0], y = startPos[1];
            for (int j = i; j < m; j++) {
                char c = s.charAt(j);
                if (c == 'U') x--;
                if (c == 'D') x++;
                if (c == 'L') y--;
                if (c == 'R') y++;
                if (x < 0 || y < 0 || x >= n || y >= n) break;
                ans[i]++;
            }
        }
        return ans;
    }

}
