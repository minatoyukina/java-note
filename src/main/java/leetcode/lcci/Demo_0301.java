package leetcode.lcci;

import org.junit.Test;

import java.util.Stack;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0301 {

    @Test
    public void test() {
        TripleInOne stack = new TripleInOne(1);
        stack.push(0, 1);
        stack.push(0, 2);
        stack.pop(0);
        stack.pop(0);
        stack.pop(0);
        stack.isEmpty(0);

    }

    @SuppressWarnings("all")
    class TripleInOne {

        private Stack[] stacks;
        private int stackSize;

        public TripleInOne(int stackSize) {
            stacks = new Stack[3];
            for (int i = 0; i < stacks.length; i++) {
                stacks[i] = new Stack();
            }
            this.stackSize = stackSize;
        }

        public void push(int stackNum, int value) {
            Stack stack = stacks[stackNum];
            if (stack.size() < stackSize) stack.push(value);
        }

        public int pop(int stackNum) {
            Stack stack = stacks[stackNum];
            if (stack.isEmpty()) return -1;
            return (int) stack.pop();
        }

        public int peek(int stackNum) {
            Stack stack = stacks[stackNum];
            if (stack.isEmpty()) return -1;
            return (int) stack.peek();
        }

        public boolean isEmpty(int stackNum) {
            Stack stack = stacks[stackNum];
            return stack.isEmpty();
        }
    }


}
