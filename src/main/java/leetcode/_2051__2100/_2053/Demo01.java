package leetcode._2051__2100._2053;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2));
    }

    public String kthDistinct(String[] arr, int k) {
        Set<String> set = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .filter(x -> x.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toSet());
        for (String s : arr) {
            if (set.contains(s)) k--;
            if (k == 0) return s;
        }
        return "";
    }


}
