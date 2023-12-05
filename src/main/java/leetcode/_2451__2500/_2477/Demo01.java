package leetcode._2451__2500._2477;

import leetcode.util.Common;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minimumFuelCost(Common.strToArray("[[0,1],[1,2]]"), 3));
        System.out.println(minimumFuelCost(Common.strToArray("[[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]]"), 2));
        System.out.println(minimumFuelCost(Common.strToArray("[[0,1],[0,2],[1,3],[1,4]]"), 5));
        System.out.println(minimumFuelCost(new int[0][], 2));
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            map.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);
            map.computeIfAbsent(road[1], k -> new HashSet<>()).add(road[0]);
        }
        return dfs(map, 0, seats, -1).liters;
    }

    static class Data {
        long people;
        long cars;
        long liters;

        public Data(long people, long cars, long liters) {
            this.people = people;
            this.cars = cars;
            this.liters = liters;
        }
    }


    private Data dfs(Map<Integer, Set<Integer>> map, int pos, int seats, int pre) {
        Set<Integer> set = map.get(pos);
        if (set == null || (pos != 0 && set.size() == 1)) return new Data(1, 1, 0);
        long people = 1, liters = 0, cars = 0;
        for (Integer x : set) {
            if (x == pre) continue;
            Data data = dfs(map, x, seats, pos);
            people += data.people;
            liters += data.liters;
            cars += data.cars;
        }
        return new Data(people, (long) Math.ceil(people / (double) seats), liters + cars);
    }

}