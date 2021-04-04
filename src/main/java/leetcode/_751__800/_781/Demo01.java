package leetcode._751__800._781;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numRabbits(new int[]{1, 1, 2}));
        System.out.println(numRabbits(new int[]{10, 10, 10}));
    }

    private int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value <= key + 1) ans += key + 1;
            else ans += value % (key + 1) == 0 ? value : ((value / (key + 1) + 1) * (key + 1));
        }
        return ans;
    }

}
