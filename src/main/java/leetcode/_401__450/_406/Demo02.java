package leetcode._401__450._406;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(Arrays.deepToString(reconstructQueue(new int[][]{
                {2, 4}, {3, 4}, {9, 0}, {0, 6}, {7, 1}, {6, 0}, {7, 3}, {2, 5}, {1, 1}, {8, 0}
        })));
    }

    private int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Comparator.comparingInt(x -> x[0]));
        int[][] ans = new int[people.length][];
        Set<Integer> memo = new HashSet<>();
        while (memo.size() < people.length) {
            for (int i = 0; i < people.length; i++) {
                if (memo.contains(i)) continue;
                int height = people[i][0];
                int higher = people[i][1];
                int count = 0;
                for (int[] an : ans) {
                    if (an == null) break;
                    if (an[0] >= height) count++;
                }
                if (higher == count) {
                    ans[memo.size()] = people[i];
                    memo.add(i);
                    break;
                }
            }
        }
        return ans;
    }


}