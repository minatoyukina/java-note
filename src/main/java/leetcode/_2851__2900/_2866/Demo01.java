package leetcode._2851__2900._2866;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maximumSumOfHeights(Arrays.asList(5, 3, 4, 1, 1)));
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long ans = 0;
        long[] prefix = new long[n], suffix = new long[n];
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s1.isEmpty() && maxHeights.get(i) < maxHeights.get(s1.peek())) s1.pop();
            if (s1.isEmpty()) prefix[i] = maxHeights.get(i) * ((long) i + 1);
            else prefix[i] = prefix[s1.peek()] + maxHeights.get(i) * ((long) i - s1.peek());
            s1.push(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!s2.isEmpty() && maxHeights.get(i) < maxHeights.get(s2.peek())) s2.pop();
            if (s2.isEmpty()) suffix[i] = maxHeights.get(i) * (n - (long) i);
            else suffix[i] = suffix[s2.peek()] + maxHeights.get(i) * (s2.peek() - (long) i);
            s2.push(i);
            ans = Math.max(ans, prefix[i] + suffix[i] - maxHeights.get(i));
        }
        return ans;
    }

}