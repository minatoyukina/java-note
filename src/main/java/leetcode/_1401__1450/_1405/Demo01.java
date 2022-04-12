package leetcode._1401__1450._1405;

import javafx.util.Pair;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestDiverseString(1, 1, 7));
        System.out.println(longestDiverseString(7, 1, 0));
    }

    public String longestDiverseString(int a, int b, int c) {
        Queue<Pair<Character, Integer>> queue = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
        if (a != 0) queue.add(new Pair<>('a', a));
        if (b != 0) queue.add(new Pair<>('b', b));
        if (c != 0) queue.add(new Pair<>('c', c));
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Pair<Character, Integer> max = queue.poll();
            assert max != null;
            Character key = max.getKey();
            if (sb.toString().endsWith(key + "" + key)) {
                if (!queue.isEmpty()) {
                    Pair<Character, Integer> second = queue.poll();
                    sb.append(second.getKey());
                    if (second.getValue() != 1) queue.offer(new Pair<>(second.getKey(), second.getValue() - 1));
                } else break;
                queue.offer(max);
            } else {
                sb.append(key);
                if (max.getValue() != 1) queue.offer(new Pair<>(key, max.getValue() - 1));
            }
        }
        return sb.toString();
    }


}