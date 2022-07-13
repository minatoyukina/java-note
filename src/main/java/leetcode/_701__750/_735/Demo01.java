package leetcode._701__750._735;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{1, -2, -2, -2})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, -10})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
    }

    private int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty()) stack.push(asteroid);
            else {
                while (true) {
                    Integer peek = stack.peek();
                    if (peek * asteroid > 0 || (peek < 0 && asteroid > 0)) {
                        stack.push(asteroid);
                        break;
                    } else {
                        if (peek == -asteroid) {
                            stack.pop();
                            break;
                        } else {
                            if (-asteroid > peek) {
                                stack.pop();
                                if (stack.isEmpty()) {
                                    stack.push(asteroid);
                                    break;
                                }
                            } else break;
                        }
                    }
                }
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

}