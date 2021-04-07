package leetcode._501__550._514;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findRotateSteps("ababcab", "acbaacba"));
        System.out.println(findRotateSteps("godding", "gd"));
    }


    private int findRotateSteps(String ring, String key) {
        return dfs(ring, key, 0, 0, 0);
    }

    private int dfs(String ring, String key, int index, int offset, int count) {
        if (offset >= key.length()) return count;
        char c = key.charAt(offset);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == c) {
                int step = Math.min(
                        Math.abs(index - i),
                        i < index ? (i + ring.length() - index) : (index + ring.length() - i));
                min = Math.min(min, dfs(ring, key, i, offset + 1, count + step + 1));
            }
        }
        return min;
    }

}