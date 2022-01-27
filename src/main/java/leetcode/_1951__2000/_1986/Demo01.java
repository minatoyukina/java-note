package leetcode._1951__2000._1986;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minSessions(new int[]{2, 3, 3, 4, 4, 4, 5, 6, 7, 10}, 12));
        System.out.println(minSessions(new int[]{3, 3}, 3));
        System.out.println(minSessions(new int[]{3, 1, 3, 1, 1}, 8));
    }

    public int minSessions(int[] tasks, int sessionTime) {
        tasks = Arrays.stream(tasks).boxed().sorted((x, y) -> y - x).mapToInt(x -> x).toArray();
        dp = new int[sessionTime + 1][(int) Math.pow(2, tasks.length)][tasks.length];
        min = Integer.MAX_VALUE;
        return dfs(tasks, sessionTime, 0, 0, 0);
    }

    private int[][][] dp;
    private int min;

    private int dfs(int[] tasks, int session, int remain, int finished, int count) {
        if (count >= min) return Integer.MAX_VALUE;
        if (finished == Math.pow(2, tasks.length) - 1) return count;
        if (dp[remain][finished][count] != 0) return dp[remain][finished][count];
        for (int i = 0; i < tasks.length; i++) {
            if ((finished >> i & 1) == 0) {
                finished += Math.pow(2, i);
                if (remain < tasks[i]) {
                    min = Math.min(min, dfs(tasks, session, session - tasks[i], finished, count + 1));
                } else {
                    min = Math.min(min, dfs(tasks, session, remain - tasks[i], finished, count));
                }
                finished -= Math.pow(2, i);
            }
        }
        return dp[remain][finished][count] = min;
    }

}