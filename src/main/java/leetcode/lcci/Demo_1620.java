package leetcode.lcci;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1620 {

    @Test
    public void test() {
        System.out.println(getValidT9Words("8733", new String[]{"tree", "used"}));
        System.out.println(getValidT9Words("2", new String[]{"a", "b", "c", "d"}));
    }

    private List<String> getValidT9Words(String num, String[] words) {
        List<String> list = new ArrayList<>();
        label:
        for (String word : words) {
            if (word.length() != num.length()) continue;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int n;
                if (c >= 'p' && c <= 's') n = 7;
                else if (c >= 't' && c <= 'v') n = 8;
                else if (c >= 'w') n = 9;
                else n = (c - 'a') / 3 + 2;
                if (n != (num.charAt(i) - '0')) continue label;
            }
            list.add(word);
        }
        return list;
    }


}
