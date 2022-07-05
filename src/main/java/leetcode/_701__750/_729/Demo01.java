package leetcode._701__750._729;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class Demo01 {


    @Test
    public void test() {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(15, 25));
        System.out.println(calendar.book(20, 30));
    }

    @SuppressWarnings("all")
    static class MyCalendar {

        private TreeMap<Integer, Integer> tree = new TreeMap<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> f = tree.floorEntry(start), c = tree.ceilingEntry(start);
            if (f != null && f.getValue() > start) return false;
            if (c != null && c.getKey() < end) return false;
            tree.put(start, end);
            return true;
        }
    }

}