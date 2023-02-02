package leetcode._1101__1150._1129;

import leetcode.util.Common;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(shortestAlternatingPaths(3,
                Common.strToArray("[[0,1],[0,2]]"),
                Common.strToArray("[[1,0]]"))));
        System.out.println(Arrays.toString(shortestAlternatingPaths(1,
                new int[][]{},
                new int[][]{})));
    }

    private int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> red = new HashMap<>(), blue = new HashMap<>();
        for (int[] redEdge : redEdges) red.computeIfAbsent(redEdge[0], k -> new ArrayList<>()).add(redEdge[1]);
        for (int[] blueEdge : blueEdges) blue.computeIfAbsent(blueEdge[0], k -> new ArrayList<>()).add(blueEdge[1]);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int step = 0;
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0], color = poll[1];
                if (x != 0 && arr[x] == -1) arr[x] = step;
                if (color == 0) {
                    red.getOrDefault(x, Collections.emptyList()).forEach(s -> queue.offer(new int[]{s, 1}));
                    blue.getOrDefault(x, Collections.emptyList()).forEach(s -> queue.offer(new int[]{s, -1}));
                } else if (color == 1) blue.getOrDefault(x, Collections.emptyList()).stream().filter(s -> visited.add(-s)).forEach(s -> queue.offer(new int[]{s, -1}));
                else red.getOrDefault(x, Collections.emptyList()).stream().filter(visited::add).forEach(s -> queue.offer(new int[]{s, 1}));
            }
            step++;
        }
        return arr;
    }
    
}