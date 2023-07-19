package leetcode._801__850._847;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, direction = 40000, max = 0;
        Map<Integer, Set<Integer>> map = Arrays.stream(obstacles).collect(Collectors.groupingBy(s -> s[0], Collectors.mapping(t -> t[1], Collectors.toSet())));
        for (int command : commands) {
            if (command == -2) direction--;
            else if (command == -1) direction++;
            else {
                int[][] arr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
                for (int i = 0; i < command; i++) {
                    x += arr[direction % 4][0];
                    y += arr[direction % 4][1];
                    if (map.getOrDefault(x, Collections.emptySet()).contains(y)) {
                        x -= arr[direction % 4][0];
                        y -= arr[direction % 4][1];
                        break;
                    } else max = Math.max(max, x * x + y * y);
                }
            }
        }
        return max;
    }

}