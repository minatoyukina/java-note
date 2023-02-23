package leetcode._1001__1050._1040;

import javafx.util.Pair;
import org.junit.Test;

import java.util.stream.IntStream;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(stoneGameII(new int[]{2, 7, 9, 4, 4}));
        System.out.println(stoneGameII(new int[]{1, 2, 3, 4, 5, 100}));
    }

    @SuppressWarnings("unchecked")
    private int stoneGameII(int[] piles) {
        dp = new Pair[piles.length][piles.length * 2][2];
        return dfs(piles, 0, 1, 1).getKey();
    }

    private Pair<Integer, Integer>[][][] dp;

    private Pair<Integer, Integer> dfs(int[] piles, int pos, int m, int aliceTurn) {
        if (pos >= piles.length) return new Pair<>(0, 0);
        if (dp[pos][m][aliceTurn] != null) return dp[pos][m][aliceTurn];
        boolean alice = aliceTurn == 1;
        int maxA = 0, maxB = 0, sum = 0;
        int total = IntStream.of(piles).skip(pos).sum();
        for (int i = pos; i < Math.min(piles.length, pos + 2 * m); i++) {
            sum += piles[i];
            int nextM = Math.max(m, i - pos + 1);
            if (alice) {
                maxA = Math.max(sum + dfs(piles, i + 1, nextM, 0).getKey(), maxA);
                maxB = total - maxA;
            } else {
                maxB = Math.max(sum + dfs(piles, i + 1, nextM, 1).getValue(), maxB);
                maxA = total - maxB;
            }
        }
        return dp[pos][m][aliceTurn] = new Pair<>(maxA, maxB);
    }
}