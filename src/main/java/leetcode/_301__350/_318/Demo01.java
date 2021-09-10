package leetcode._301__350._318;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
    }

    public int maxProduct(String[] words) {
        List<String> list = Arrays.stream(words).map(s -> {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }).collect(Collectors.toList());
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                String a = list.get(i), b = list.get(j);
                int left = 0, right = 0;
                boolean flag = true;
                while (left < a.length() && right < b.length()) {
                    if (a.charAt(left) == b.charAt(right)) {
                        flag = false;
                        break;
                    }
                    if (a.charAt(left) > b.charAt(right)) right++;
                    else left++;
                }
                if (flag) max = Math.max(max, a.length() * b.length());
            }
        }
        return max;
    }

}