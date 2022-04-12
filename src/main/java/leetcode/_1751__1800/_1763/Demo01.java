package leetcode._1751__1800._1763;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestNiceSubstring("YazaAay"));
    }

    public String longestNiceSubstring(String s) {
        int l = s.length();
        String ans = "";
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                String ss = s.substring(i, j + 1);
                if (Arrays.stream(ss.split(""))
                        .collect(Collectors.groupingBy(String::toLowerCase, Collectors.toSet())).values().stream()
                        .allMatch(x -> x.size() > 1)) {
                    if (j - i + 1 > ans.length()) ans = ss;
                }
            }
        }
        return ans;
    }

}