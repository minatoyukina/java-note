package leetcode._1951__2000._1980;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findDifferentBinaryString(new String[]{"01", "10"}));
        System.out.println(findDifferentBinaryString(new String[]{"111", "000", "001"}));
    }

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(nums[i], 2);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) if (arr[i] > i) return append(Integer.toBinaryString(i), n);
        return append(Integer.toBinaryString(n), n);
    }

    private String append(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < n) sb.insert(0, "0");
        return sb.toString();
    }

}