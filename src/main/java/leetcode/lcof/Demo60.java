package leetcode.lcof;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo60 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(dicesProbability(3)));
        System.out.println(Arrays.toString(dicesProbability(11)));
    }

    private double[] dicesProbability(int n) {
        Map<Integer, Integer> map = dfs(1, n);
        double[] ans = new double[map.size()];
        int index = 0;
        double pow = Math.pow(6, n);
        for (Integer integer : map.values()) ans[index++] = integer / pow;
        return ans;
    }

    private Map<Integer, Integer> dfs(int index, int n) {
        Map<Integer, Integer> ans = new HashMap<>();
        if (index == n) {
            for (int i = 1; i <= 6; i++) ans.put(i, 1);
            return ans;
        }
        Map<Integer, Integer> map = dfs(index + 1, n);
        for (int i = 1; i <= 6; i++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey() + i;
                ans.put(key, ans.getOrDefault(key, 0) + entry.getValue());
            }
        }
        return ans;
    }

}
