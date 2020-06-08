package leetcode._846;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(isNStraightHand(new int[]{1, 1, 2, 2, 3, 3}, 2));
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
    }

    @SuppressWarnings("all")
    private boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        LinkedList<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(hand);
        for (int i : hand) queue.addLast(i);
        while (!queue.isEmpty()) {
            int tmp = queue.pollFirst();
            for (int i = 1; i < W; i++) {
                int x = 0;
                if (queue.isEmpty()) return false;
                x = queue.pollFirst();
                if (x == tmp + 1) tmp += 1;
                else if (x > tmp + 1) return false;
                else stack.push(x + i - i--);
            }
            while (!stack.isEmpty()) queue.addFirst(stack.pop());
        }
        return queue.isEmpty();
    }

}
