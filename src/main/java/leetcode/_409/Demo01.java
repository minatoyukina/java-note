package leetcode._409;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("bb"));
    }

    private int longestPalindrome(String s) {
        Map<String, Long> map = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int ans = 0;
        boolean flag = false;
        for (Long value : map.values()) {
            if (value % 2 == 0) ans += value;
            else {
                flag = true;
                ans += value - 1;
            }
        }
        return flag ? ans + 1 : ans;
    }

}
