package leetcode._351__400._394;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("11[ab]"));
        System.out.println(decodeString("23[abc34[cd]]56[xy]"));
    }

    private String decodeString(String s) {
        if (s.contains("[")) {
            Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, Integer> num = new HashMap<>();
            StringBuilder tmp = new StringBuilder();
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    tmp.append(s.charAt(i));
                } else if (s.charAt(i) == '[') {
                    num.put(i, Integer.parseInt(tmp.toString()));
                    tmp = new StringBuilder();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        stack.pop();
                        stack.push(i);
                    }
                } else {
                    tmp = new StringBuilder();
                }
                if (s.charAt(i) == ']' && !stack.isEmpty()) {
                    map.put(stack.pop(), i);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(i)) {
                    String substring = s.substring(i + 1, map.get(i));
                    for (int j = 0; j < num.get(i); j++) sb.append(substring);
                    i = map.get(i);
                } else sb.append(s.charAt(i));
            }
            for (Integer value : num.values()) {
                int k;
                while ((k = sb.indexOf(value.toString())) >= 0 && sb.charAt(k + value.toString().length()) != '[') {
                    sb.delete(k, k + value.toString().length());
                }
            }
            return decodeString(sb.toString());
        }
        return s;
    }
}
