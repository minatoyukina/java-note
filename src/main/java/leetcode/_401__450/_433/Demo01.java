package leetcode._401__450._433;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }

    private int minMutation(String start, String end, String[] bank) {
        Set<Integer> set = new HashSet<>();
        for (String s : bank) set.add(transfer(s));
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int step = 0;
        int s = transfer(start);
        int e = transfer(end);
        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer cur = queue.poll();
                assert cur != null;
                if (cur == e) return step;
                for (int i = 1; i <= 8; i++) {
                    int bit = (int) Math.pow(10, i);
                    int v = String.valueOf(cur).charAt(8 - i) - '0';
                    for (int j = 1; j <= 4; j++) {
                        if (j == v) continue;
                        int x = cur + (j - v) * bit / 10;
                        if (set.contains(x) && !visited.contains(x)) {
                            queue.offer(x);
                            visited.add(x);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private int transfer(String s) {
        String replace = s
                .replace('A', '1')
                .replace('C', '2')
                .replace('G', '3')
                .replace('T', '4');
        return Integer.parseInt(replace);
    }

}