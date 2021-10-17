package leetcode._351__400._385;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(deserialize("[123,[456,[789]]]"));

    }

    public NestedInteger deserialize(String s) {
        if (s.length() == 0) return new NestedInteger();
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        if (s.length() == 2) return new NestedInteger();
        NestedInteger ni = new NestedInteger();
        for (int start = 1, i = 1, count = 0; i < s.length(); i++) {
            if (count == 0 && (s.charAt(i) == ',' || s.length() - 1 == i)) {
                ni.add(deserialize(s.substring(start, i)));
                start = i + 1;
            } else if (s.charAt(i) == '[') {
                count++;
            } else if (s.charAt(i) == ']') {
                count--;
            }
        }
        return ni;
    }


    @SuppressWarnings("all")
    static class NestedInteger {

        int value;
        List<NestedInteger> list = new ArrayList<>();

        NestedInteger() {

        }

        NestedInteger(int value) {
            this.value = value;
        }

        boolean isInteger() {
            return list == null || list.isEmpty();
        }

        Integer getInteger() {
            return value;
        }

        void setInteger(int value) {
            this.value = value;
        }

        void add(NestedInteger ni) {
            list.add(ni);
        }


        List<NestedInteger> getList() {
            return list;
        }

        @Override
        public String toString() {
            return "NestedInteger{" +
                    "value=" + value +
                    ", list=" + list +
                    '}';
        }
    }

}