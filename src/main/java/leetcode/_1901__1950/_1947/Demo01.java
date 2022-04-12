package leetcode._1901__1950._1947;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxCompatibilitySum(
                new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 1}},
                new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 1, 0}}));
    }

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return dfs(students, mentors, 0, new HashSet<>());
    }

    private int dfs(int[][] students, int[][] mentors, int pos, Set<Integer> matched) {
        if (pos == students.length) return 0;
        int max = 0;
        for (int i = 0; i < mentors.length; i++) {
            if (matched.contains(i)) continue;
            int[] student = students[pos];
            int same = 0;
            for (int j = 0; j < student.length; j++) if (student[j] == mentors[i][j]) same++;
            matched.add(i);
            max = Math.max(max, same + dfs(students, mentors, pos + 1, matched));
            matched.remove(i);
        }
        return max;
    }
}