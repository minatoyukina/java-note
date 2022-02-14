package leetcode._1801__1850._1807;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(evaluate("(name)is(age)yearsold", Arrays.asList(Arrays.asList("name", "bob"), Arrays.asList("age", "two"))));
    }

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = knowledge.stream().collect(Collectors.toMap(x -> x.get(0), x -> x.get(1)));
        int left = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left = i;
            else if (c == ')') {
                sb.append(map.getOrDefault(s.substring(left + 1, i), "?"));
                left = -1;
            } else if (left == -1) sb.append(c);
        }
        return sb.toString();
    }

}