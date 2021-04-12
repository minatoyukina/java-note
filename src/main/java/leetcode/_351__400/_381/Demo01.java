package leetcode._351__400._381;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        RandomizedCollection collection = new RandomizedCollection();
        System.out.println(collection.insert(10));
        System.out.println(collection.insert(10));
        System.out.println(collection.insert(20));
        System.out.println(collection.insert(20));
        System.out.println(collection.insert(30));
        System.out.println(collection.insert(30));
        System.out.println(collection.remove(10));
        System.out.println(collection.remove(20));
        System.out.println(collection.remove(20));
        System.out.println(collection.remove(10));
        System.out.println(collection.remove(30));
        System.out.println(collection.insert(40));
        System.out.println(collection.remove(30));
        System.out.println(collection.remove(30));
        System.out.println(collection.getRandom());
    }

    @SuppressWarnings("all")
    class RandomizedCollection {

        private List<Integer> list;
        private Map<Integer, Deque<Integer>> map;
        private int length;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (length == list.size()) list.add(val);
            else list.set(length, val);
            Deque<Integer> deque = map.getOrDefault(val, new LinkedList<>());
            deque.offerLast(length++);
            map.put(val, deque);
            return deque.size() == 1;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            Deque<Integer> pre = map.get(val);
            if (pre != null && pre.size() >= 1) {
                Integer index = pre.pollFirst();
                if (index == null) return false;
                Integer last = list.get(--length);
                if (val == last) {
                    return true;
                }
                Deque<Integer> deque = map.get(last);
                deque.pollLast();
                deque.offerFirst(index);
                list.set(index, last);
                return true;
            }
            return false;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            if (length == 0) return -1;
            int i = new Random().nextInt(length);
            return list.get(i);
        }
    }

}