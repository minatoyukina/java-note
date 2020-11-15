package leetcode._651__700._670;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(9973));

    }

    private int maximumSwap(int num) {
        String s = String.valueOf(num);
        String[] split = s.split("");
        String ss = Arrays.stream(split)
                .sorted((x, y) -> Integer.parseInt(y) - Integer.parseInt(x))
                .collect(Collectors.joining());
        for (int i = 0; i < ss.length(); i++) {
            if (s.charAt(i) != ss.charAt(i)) {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, ss.charAt(i));
                sb.setCharAt(s.lastIndexOf(ss.charAt(i)), s.charAt(i));
                return Integer.parseInt(sb.toString());
            }
        }
        return num;
    }
}
