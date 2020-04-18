package leetcode._101__150._115;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Demo01 {

    @Test
    public void test() {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(1);
        stack.push(0);
        stack.push(0);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());

    }

    class MinStack {

        private List<Integer> list = new ArrayList<>();
        private TreeMap<Integer, Integer> map = new TreeMap<>();

        MinStack() {

        }

        void push(int x) {
            list.add(x);
            if (map.containsKey(x)) map.put(x, map.get(x) + 1);
            else map.put(x, 1);
        }

        void pop() {
            if (!list.isEmpty()) {
                int last = list.size() - 1;
                Integer integer = list.get(last);
                if (map.containsKey(integer)) {
                    Integer count = map.get(integer);
                    if (count == 1) map.remove(integer);
                    else map.put(integer, count - 1);
                }
                list.remove(last);
            }
        }

        int top() {
            if (list.size() > 0) return list.get(list.size() - 1);
            return 0;
        }

        int getMin() {
            return map.firstKey();
        }
    }
}
