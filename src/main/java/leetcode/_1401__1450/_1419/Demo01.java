package leetcode._1419;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minNumberOfFrogs("crcoakroak"));
        System.out.println(minNumberOfFrogs("croakcroak"));
        System.out.println(minNumberOfFrogs("okcracakroroakacckor"));
    }

    private int minNumberOfFrogs(String croakOfFrogs) {
        Map<String, Integer> map = new HashMap<>();
        char[] chars = croakOfFrogs.toCharArray();
        for (char c : chars) {
            if (c == 'c') {
                Integer croak = map.get("croak");
                if (croak != null && croak >= 1) map.put("croak", croak - 1);
                map.merge("c", 1, (a, b) -> a + b);
            } else {
                String key = "croak".substring(0, "croak".indexOf(c));
                Integer integer = map.get(key);
                if (integer != null) {
                    if (integer > 1) map.put(key, integer - 1);
                    else map.remove(key);
                    map.merge(key + c, 1, (a, b) -> a + b);
                } else return -1;
            }
        }
        Integer integer = map.get("croak");
        if (integer == null || integer == 0) return -1;
        return integer;
    }
}
