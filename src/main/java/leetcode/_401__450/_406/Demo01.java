package leetcode._401__450._406;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.deepToString(reconstructQueue(new int[][]{
                {2, 4}, {3, 4}, {9, 0}, {0, 6}, {7, 1}, {6, 0}, {7, 3}, {2, 5}, {1, 1}, {8, 0}
        })));
    }

    private int[][] reconstructQueue(int[][] people) {
        int[][] ans = new int[people.length][2];
        Arrays.fill(ans, null);
        return dfs(people, new HashSet<>(), ans);
    }

    private int[][] dfs(int[][] people, Set<Integer> memo, int[][] ans) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] an : ans) {
            if (an == null) break;
            count++;
            map.put(an[0], map.getOrDefault(an[0], 0) + 1);
        }
        for (int i = 0; i < people.length; i++) {
            int height = people[i][0];
            int pre = people[i][1];
            int higher = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() >= height) higher += entry.getValue();
            }
            if (!memo.contains(i) && pre == higher) {
                Set<Integer> copy = new HashSet<>(memo);
                copy.add(i);
                int[][] arr = new int[ans.length][2];
                for (int j = 0; j < ans.length; j++) {
                    arr[j] = ans[j] == null ? null : Arrays.copyOf(ans[j], 2);
                }
                arr[count] = people[i];
                int[][] dfs = dfs(people, copy, arr);
                boolean flag = true;
                for (int[] df : dfs) {
                    if (df == null) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return dfs;
            }
        }
        return ans;
    }

}