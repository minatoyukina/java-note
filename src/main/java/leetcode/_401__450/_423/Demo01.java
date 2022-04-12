package leetcode._401__450._423;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(originalDigits("owoztneoer"));
        System.out.println(originalDigits("esvne"));
    }

    public String originalDigits(String s) {
        String[] nums = {"zero", "six", "four", "two", "eight", "three", "five", "one", "seven", "nine"};
        char[] unique = {'z', 'x', 'u', 'w', 'g', 'h', 'f', 'o', 's', 'n'};
        int[] index = {0, 6, 4, 2, 8, 3, 5, 1, 7, 9};
        int[] arr = new int[10];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        for (int i = 0; i < unique.length; i++) {
            while (map.containsKey(unique[i]) && map.get(unique[i]) > 0) {
                for (int j = 0; j < nums[i].length(); j++) {
                    char c = nums[i].charAt(j);
                    map.put(c, map.get(c) - 1);
                }
                arr[index[i]]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) for (int j = 0; j < arr[i]; j++) sb.append(i);
        return sb.toString();
    }

}