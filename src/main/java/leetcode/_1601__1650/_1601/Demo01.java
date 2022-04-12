package leetcode._1601__1650._1601;

import leetcode.util.Common;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maximumRequests(6, Common.strToArray("[[2,2],[1,5],[2,1],[4,1],[2,3],[0,3],[5,2],[0,1],[2,4],[0,3],[1,3],[0,4],[2,0]]")));
    }

    @SuppressWarnings("all")
    public int maximumRequests(int n, int[][] requests) {
        dp = new int[1 << requests.length];
        Arrays.fill(dp, -1);
        Map<Integer, Integer> from = new HashMap<>(), to = new HashMap<>();
        for (int[] request : requests) {
            from.put(request[0], from.getOrDefault(request[0], 0) + 1);
            to.put(request[1], to.getOrDefault(request[1], 0) + 1);
        }
        return dfs(from, to, (1 << requests.length) - 1, requests);
    }

    private int M;
    private int[] dp;

    private int dfs(Map<Integer, Integer> from, Map<Integer, Integer> to, int mask, int[][] requests) {
        if (from.equals(to)) return M = dp[mask] = Integer.bitCount(mask);
        if (dp[mask] != -1) return dp[mask];
        if (Integer.bitCount(mask) <= M) return M;
        int max = 0;
        for (int i = 0; i < requests.length; i++) {
            if ((mask >> i & 1) == 1) {
                mask -= 1 << i;
                int fk = requests[i][0], tk = requests[i][1];
                int fv = from.get(fk), tv = to.get(tk);
                if (fv > 1) from.put(fk, fv - 1);
                else from.remove(fk);
                if (tv > 1) to.put(tk, tv - 1);
                else to.remove(tk);
                max = Math.max(max, dfs(from, to, mask, requests));
                mask += 1 << i;
                from.put(fk, from.getOrDefault(fk, 0) + 1);
                to.put(tk, to.getOrDefault(tk, 0) + 1);
            }
        }
        return M = dp[mask] = max;
    }

}