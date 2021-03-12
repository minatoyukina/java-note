package leetcode._101__150._134;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }

    private int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) if (dfs(i, 0, gas, cost, 0)) return i;
        return -1;
    }

    private boolean dfs(int i, int remain, int[] gas, int[] cost, int count) {
        if (count == cost.length) return true;
        int oil = remain + gas[i];
        int next = i + 1 >= cost.length ? 0 : i + 1;
        if (oil < cost[i]) return false;
        return dfs(next, oil - cost[i], gas, cost, ++count);
    }

}