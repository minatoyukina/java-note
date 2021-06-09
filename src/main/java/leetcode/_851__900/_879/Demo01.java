package leetcode._851__900._879;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
        System.out.println(profitableSchemes(5, 3, new int[]{2, 3}, new int[]{2, 3}));
    }

    private int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new HashMap<>();
        return dfs(n, minProfit, group, profit, 0, 0, 0);
    }

    private Map<Integer, Map<Integer, Map<Integer, Integer>>> dp;

    private int dfs(int n, int minProfit, int[] group, int[] profits, int profit, int people, int index) {
        if (people > n) return 0;
        if (index > group.length) return profit >= minProfit ? 1 : 0;
        if (dp.getOrDefault(profit, new HashMap<>()).getOrDefault(people, new HashMap<>()).get(index) != null)
            return dp.get(profit).get(people).get(index);
        int ans = 0;
        for (int i = index; i <= group.length; i++) {
            ans += dfs(n, minProfit, group, profits,
                    profit + (i == profits.length ? 0 : profits[i]),
                    people + (i == group.length ? 0 : group[i]), i + 1);
            ans %= (int) (1e9 + 7);
        }
        Map<Integer, Map<Integer, Integer>> s1 = dp.getOrDefault(profit, new HashMap<>());
        Map<Integer, Integer> s2 = s1.getOrDefault(people, new HashMap<>());
        s2.put(index, ans);
        s1.put(people, s2);
        dp.put(profit, s1);
        return ans;
    }

}