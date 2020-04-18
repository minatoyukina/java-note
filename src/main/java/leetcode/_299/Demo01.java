package leetcode._299;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
    }


    private String getHint(String secret, String guess) {
        int a = 0, b = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i), g = guess.charAt(i);
            if (s == g) a++;
            else {
                if (map.containsKey(s)) map.put(s, map.get(s) + 1);
                else map.put(s, 1);
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i), g = guess.charAt(i);
            if (s != g && map.containsKey(g)) {
                if (map.get(g) > 0) {
                    b++;
                    map.put(g, map.get(g) - 1);
                }
            }
        }
        return a + "A" + b + "B";
    }

}
