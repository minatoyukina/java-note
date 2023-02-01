package leetcode._2301__2350._2325;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        System.out.println(decodeMessage("a", "a"));
    }


    private String decodeMessage(String key, String message) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c != ' ' && !map.containsKey(c)) map.put(c, map.size());
        }
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') sb.append(" ");
            else sb.append((char) (map.get(message.charAt(i)) + 'a'));
        }
        return sb.toString();
    }

}
