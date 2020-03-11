package leetcode._17;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(letterCombinations("234"));
        System.out.println(letterCombinations("23421987"));
    }

    private List<String> letterCombinations(String digits) {
        digits = digits.replaceAll("1", "");
        Map<String, List<String>> map = new HashMap<>();
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));
        List<List<String>> list = new ArrayList<>();
        Arrays.stream(digits.split("")).forEach(s -> list.add(map.get(s)));
        return list.stream().reduce((x, y) -> x.stream().map(i -> y.stream().map(j -> i + j))
                .flatMap(Function.identity()).collect(Collectors.toList())).orElse(null);
//        return list.stream().reduce((x, y) -> {
//            List<String> tmp = new ArrayList<>();
//            x.forEach(a -> y.forEach(b -> tmp.add(a + b)));
//            return tmp;
//        }).orElse(null);
    }

}
