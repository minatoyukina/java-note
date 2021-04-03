package leetcode._701__750._703;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class Demo01 {


    @Test
    public void test() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    @SuppressWarnings("all")
    class KthLargest {

        private Queue<Integer> queue = new PriorityQueue<>();
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                queue.add(num);
                if (queue.size() > k)
                    queue.poll();
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.add(val);
                return queue.peek();
            }
            queue.add(val);
            queue.poll();
            return queue.peek();
        }
    }


}
