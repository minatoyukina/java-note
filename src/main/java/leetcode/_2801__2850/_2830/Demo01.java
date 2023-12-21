package leetcode._2801__2850._2830;

import leetcode.util.Common;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maximizeTheProfit(5, Common.strToList("[[1,3,10],[1,3,3],[0,0,1],[0,0,7]]").stream().map(s -> s.stream().map(Integer::parseInt).collect(Collectors.toList())).collect(Collectors.toList())));
    }

    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        int[] dp = new int[n];
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (List<Integer> offer : offers) {
            map.computeIfAbsent(offer.get(1), k -> new HashMap<>()).compute(offer.get(0), (k, v) -> Math.max(Optional.ofNullable(v).orElse(offer.get(2)), offer.get(2)));
        }
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> sub = map.getOrDefault(i, new HashMap<>());
            if (i > 0) dp[i] = dp[i - 1];
            for (Map.Entry<Integer, Integer> entry : sub.entrySet()) {
                dp[i] = Math.max(dp[i], (entry.getKey() - 1 >= 0 ? dp[entry.getKey() - 1] : 0) + entry.getValue());
            }
        }
        return dp[n - 1];
    }

}