package leetcode._651__700._675;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(cutOffTree(Lists.newArrayList(
                Lists.newArrayList(54581641, 64080174, 24346381, 69107959),
                Lists.newArrayList(86374198, 61363882, 68783324, 79706116),
                Lists.newArrayList(668150, 92178815, 89819108, 94701471),
                Lists.newArrayList(83920491, 22724204, 46281641, 47531096),
                Lists.newArrayList(89078499, 18904913, 25462145, 60813308))));
        System.out.println(cutOffTree(Lists.newArrayList(
                Lists.newArrayList(1, 2, 3),
                Lists.newArrayList(0, 0, 4),
                Lists.newArrayList(7, 6, 5))));
    }

    private int cutOffTree(List<List<Integer>> forest) {
        TreeMap<Integer, int[]> tree = new TreeMap<>();
        tree.put(0, new int[]{0, 0});
        for (int i = 0; i < forest.size(); i++)
            for (int j = 0; j < forest.get(i).size(); j++)
                if (forest.get(i).get(j) > 1) tree.put(forest.get(i).get(j), new int[]{i, j});
        int cur = 0;
        int step = 0;
        while (cur < tree.lastKey()) {
            int higher = tree.higherKey(cur);
            int x = bfs(forest, tree.get(cur)[0], tree.get(cur)[1], tree.get(higher)[0], tree.get(higher)[1]);
            if (x == -1) return -1;
            step += x;
            cur = higher;
        }
        return step;
    }

    private int bfs(List<List<Integer>> forest, int x1, int y1, int x2, int y2) {
        Set<Long> visited = new HashSet<>();
        visited.add(x1 * (long) 100 + y1);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x1, y1});
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                assert cur != null;
                if (cur[0] == x2 && cur[1] == y2) return step;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i * j == 0 && i + j != 0) {
                            int x = cur[0] + i, y = cur[1] + j;
                            if (x < 0 || y < 0 || x >= forest.size() || y >= forest.get(0).size() ||
                                    visited.contains((long) 100 * x + y) || forest.get(x).get(y) == 0) continue;
                            queue.offer(new int[]{x, y});
                            visited.add((long) 100 * x + y);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

}