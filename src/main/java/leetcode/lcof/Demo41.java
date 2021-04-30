package leetcode.lcof;

import org.junit.Test;

import java.util.PriorityQueue;

public class Demo41 {

    @Test
    public void test() {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
        finder.addNum(2);
        System.out.println(finder.findMedian());
    }

    @SuppressWarnings("all")
    class MedianFinder {

        private PriorityQueue<Integer> big;
        private PriorityQueue<Integer> small;

        public MedianFinder() {
            big = new PriorityQueue<>();
            small = new PriorityQueue<>((x, y) -> y - x);
        }

        public void addNum(int num) {
            if (small.isEmpty() && big.isEmpty()) {
                small.offer(num);
                return;
            }
            if (small.size() >= big.size()) {
                if (num >= small.peek()) big.offer(num);
                else {
                    big.offer(small.poll());
                    small.offer(num);
                }
            } else {
                if (num <= big.peek()) small.offer(num);
                else {
                    small.offer(big.poll());
                    big.offer(num);
                }
            }
        }

        public double findMedian() {
            if (big.size() == small.size()) return (big.peek() + small.peek()) / (double) 2;
            else return big.size() > small.size() ? big.peek() : small.peek();
        }
    }
}
