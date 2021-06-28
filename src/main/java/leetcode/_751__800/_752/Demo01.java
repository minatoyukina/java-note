package leetcode._751__800._752;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
        System.out.println(openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }

    private int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        String init = "0000";
        if (dead.contains(init)) return -1;
        Set<String> visited = new HashSet<>();
        queue.offer(init);
        visited.add(init);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                assert s != null;
                if (s.equals(target)) return ans;
                for (int j = 0; j < 4; j++) {
                    char c = s.charAt(j);
                    String s1 = new StringBuilder(s).replace(j, j + 1, c == '9' ? "0" : String.valueOf((char) (c + 1))).toString();
                    if (!dead.contains(s1) && !visited.contains(s1)) queue.offer(s1);
                    visited.add(s1);
                    String s2 = new StringBuilder(s).replace(j, j + 1, c == '0' ? "9" : String.valueOf((char) (c - 1))).toString();
                    if (!dead.contains(s2) && !visited.contains(s2)) queue.offer(s2);
                    visited.add(s2);
                }
            }
            ans++;
        }
        return -1;
    }


}
