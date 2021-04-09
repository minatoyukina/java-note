package leetcode._1351__1400._1381;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        System.out.println(customStack.pop());
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.increment(5, 100);
        customStack.increment(2, 100);
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
    }

    @SuppressWarnings("all")
    class CustomStack {

        private int[] arr;
        private int offset;

        public CustomStack(int maxSize) {
            arr = new int[maxSize];
        }

        public void push(int x) {
            if (offset != arr.length) arr[offset++] = x;
        }

        public int pop() {
            if (offset == 0) return -1;
            return arr[--offset];
        }

        public void increment(int k, int val) {
            for (int i = 0; i < offset; i++) {
                if (--k < 0) break;
                arr[i] += val;
            }
        }
    }

}