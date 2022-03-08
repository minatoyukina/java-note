package leetcode._1451__1500._1475;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(finalPrices(new int[]{8, 4, 6, 2, 3})));
    }

    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) prices[stack.pop()] -= prices[i];
            stack.push(i);
        }
        return prices;
    }

}