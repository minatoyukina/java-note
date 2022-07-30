package leetcode._951__1000._952;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(largestComponentSize(new int[]{20, 50, 9, 63, 1}));
        System.out.println(largestComponentSize(new int[]{2, 3, 6, 7, 4, 12, 21, 39}));
    }

    private int largestComponentSize(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100_000; i++) {
            if (isPrime(i)) list.add(i);
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int num : nums) {
            for (Integer x : list) {
                if (num < x) break;
                if (num % x == 0) map.computeIfAbsent(x, k -> new HashSet<>()).add(num);
            }
        }
        Map<Integer, Set<Integer>> edge = new HashMap<>();
        for (Set<Integer> value : map.values()) {
            for (Integer x : value) {
                edge.computeIfAbsent(x, k -> new HashSet<>()).addAll(value);
                edge.get(x).remove(x);
            }
        }
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            max = Math.max(max, set.size());
            if (!set.contains(num)) {
                set = new HashSet<>();
                dfs(edge, set, num);
            }
        }
        return max;
    }

    private void dfs(Map<Integer, Set<Integer>> edge, Set<Integer> set, int cur) {
        Set<Integer> next = edge.getOrDefault(cur, Collections.emptySet());
        for (Integer integer : next) {
            if (!set.contains(integer)) {
                set.add(integer);
                dfs(edge, set, integer);
            }
        }
    }

    private boolean isPrime(int n) {
        if (n == 2 || n == 3) return true;
        if (n == 1 || n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) if (n % i == 0) return false;
        return true;
    }

}