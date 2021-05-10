package leetcode._351__400._365;

import javafx.util.Pair;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(canMeasureWater(5, 3, 4));
        System.out.println(canMeasureWater(2, 6, 5));
    }

    private boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Set<Long> dp = new HashSet<>();
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(0, 0));
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pop = stack.pop();
            int w1 = pop.getKey();
            int w2 = pop.getValue();
            long hash = (long) w1 * 1000001 + w2;
            if (dp.contains(hash)) continue;
            dp.add(hash);
            if (w1 == targetCapacity || w2 == targetCapacity || w1 + w2 == targetCapacity) return true;
            stack.push(new Pair<>(jug1Capacity, w2));
            stack.push(new Pair<>(w1, jug2Capacity));
            stack.push(new Pair<>(0, w2));
            stack.push(new Pair<>(w1, 0));
            if (w1 > jug2Capacity - w2) stack.push(new Pair<>(w1 - (jug2Capacity - w2), jug2Capacity));
            else stack.push(new Pair<>(0, w1 + w2));
            if (w2 > jug1Capacity - w1) stack.push(new Pair<>(jug1Capacity, w2 - (jug1Capacity - w1)));
            else stack.push(new Pair<>(w1 + w2, 0));
        }
        return false;
    }
}