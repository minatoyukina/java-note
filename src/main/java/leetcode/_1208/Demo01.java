package leetcode._1208;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(equalSubstring("abceed", "bcdeef", 3));
        System.out.println(equalSubstring("a", "c", 1));
        System.out.println(equalSubstring("abck", "acde", 0));
    }

    private int equalSubstring(String s, String t, int maxCost) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int[] arr = new int[chars1.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(chars1[i] - chars2[i]);
        }
        int sum = 0;
        int max = 0;
        int left = 0, right = 0;
        while (right < arr.length) {
            if (sum + arr[right] <= maxCost) {
                sum += arr[right];
                right++;
            } else {
                max = Math.max(max, right - left);
                sum -= arr[left];
                left++;
            }
        }
        return Math.max(max, right - left);
    }
}
