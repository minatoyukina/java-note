package leetcode._2101__2150._2103;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(countPoints("B0B6G0R6R0R6G9"));
    }

    public int countPoints(String rings) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < rings.length(); i += 2) {
            char a = rings.charAt(i), b = rings.charAt(i + 1);
            map.computeIfAbsent(b, k -> new HashSet<>()).add(a);
        }
        return (int) map.values().stream().filter(x -> x.size() == 3).count();
    }


}
