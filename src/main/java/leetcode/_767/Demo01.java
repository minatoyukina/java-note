package leetcode._767;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(reorganizeString("aaab"));
        System.out.println(reorganizeString("aab"));
    }

    private String reorganizeString(String S) {
        Map<String, Long> map = Arrays.stream(S.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        if (map.values().stream().anyMatch(x -> x > (S.length() + 1) / 2)) return "";
        Stack<String> stack = new Stack<>();
        map.entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .forEach(x -> LongStream.range(0, x.getValue()).forEach(t -> stack.push(x.getKey())));
        String[] strings = new String[S.length()];
        for (int i = 0; i < strings.length; i = i + 2) strings[i] = stack.pop();
        for (int i = 1; i < strings.length; i = i + 2) strings[i] = stack.pop();
        return String.join("", strings);
    }


}
