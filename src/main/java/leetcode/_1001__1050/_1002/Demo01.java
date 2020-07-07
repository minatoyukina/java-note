package leetcode._1001__1050._1002;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {

        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(Arrays.toString("10001".split("0+")));
    }

    private List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        List<Map<String, Long>> mapList = new ArrayList<>();
        for (String s : A) {
            Map<String, Long> collect = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            mapList.add(collect);
        }
        mapList.get(0).forEach((x, y) -> {
            if (mapList.stream().allMatch(s -> s.containsKey(x))) {
                for (long i = 0; i < mapList.stream()
                        .map(a -> a.get(x)).min(Long::compareTo).orElse(0L); i++) {
                    list.add(x);
                }
            }
        });
        return list;
    }


}
