package leetcode._601__650._621;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 1));
    }

    private int leastInterval(char[] tasks, int n) {
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) map.put(c, map.getOrDefault(c, 0) + 1);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) queue.offer(entry);
        int ans = 0;
        while (!queue.isEmpty()) {
            Stack<Map.Entry<Character, Integer>> stack = new Stack<>();
            int count = 0;
            for (int i = 0; i <= n; i++) {
                if (queue.size() > 0) {
                    count++;
                    Map.Entry<Character, Integer> poll = queue.poll();
                    if (poll != null && poll.getValue() > 1) {
                        poll.setValue(poll.getValue() - 1);
                        stack.push(poll);
                    }
                }
            }
            if (stack.isEmpty()) ans += count;
            else ans += n + 1;
            while (!stack.isEmpty()) queue.add(stack.pop());
        }
        return ans;
    }
}