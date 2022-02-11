package leetcode._2051__2100._2086;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(minimumBuckets(".H.H."));
    }

    public int minimumBuckets(String street) {
        if (street.contains("HHH") || street.equals("H") || street.equals("HH")) return -1;
        String replace = street.replace("H.H", "");
        int ans = street.length() - replace.length();
        return (int) (Arrays.stream(replace.split("")).filter(s -> s.equals("H")).count() + ans / 3);
    }


}
