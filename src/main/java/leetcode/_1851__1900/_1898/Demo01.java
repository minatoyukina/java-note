package leetcode._1851__1900._1898;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maximumRemovals("abcbddddd", "abcd", new int[]{3, 2, 1, 4, 5, 6}));
        System.out.println(maximumRemovals("abcab", "abc", new int[]{0, 1, 2, 3, 4}));
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0, right = removable.length;
        while (left <= right) {
            if (right - left == 1) return check(s, p, removable, right) ? right : left;
            int mid = (right + left) / 2;
            if (check(s, p, removable, mid)) left = mid;
            else right = mid - 1;
        }
        return left;
    }

    private boolean check(String s, String p, int[] removable, int k) {
        int i = 0, j = 0;
        Set<Integer> set = Arrays.stream(removable).limit(k).boxed().collect(Collectors.toSet());
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j) && !set.contains(i)) j++;
            i++;
        }
        return j >= p.length();
    }

}