package leetcode._2851__2900._2865;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maximumSumOfHeights(Arrays.asList(5, 3, 4, 1, 1)));
        System.out.println(maximumSumOfHeights(Arrays.asList(6, 5, 3, 9, 2, 7)));
        System.out.println(maximumSumOfHeights(Arrays.asList(3, 2, 5, 5, 2, 3)));
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        Stack<Integer> pre = new Stack<>(), suf = new Stack<>();
        int n = maxHeights.size();
        long[] left = new long[n], right = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            while (!pre.isEmpty() && maxHeights.get(pre.peek()) > maxHeights.get(i)) pre.pop();
            left[i] = pre.isEmpty() ? (long) maxHeights.get(i) * (i + 1) : (left[pre.peek()] + (long) maxHeights.get(i) * (i - pre.peek()));
            pre.push(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!suf.isEmpty() && maxHeights.get(suf.peek()) > maxHeights.get(i)) suf.pop();
            right[i] = suf.isEmpty() ? (long) maxHeights.get(i) * (n - i) : (right[suf.peek()] + (long) maxHeights.get(i) * (suf.peek() - i));
            max = Math.max(max, right[i] + left[i] - maxHeights.get(i));
            suf.push(i);
        }
        return max;
    }

}