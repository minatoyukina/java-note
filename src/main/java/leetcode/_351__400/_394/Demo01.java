package leetcode._351__400._394;

import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo01 {


    @Test
    public void test() {
//        System.out.println(decodeString("3[a]2[bc]"));
//        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(getMoneyAmount(6));
    }

    public int getMoneyAmount(int n) {
        int ans = 0;
        int i = (1 + n) / 2;
        if (n % 2 == 0 && i + 1 != n) ans += n - 1;
        while (i < n) {
            ans += i;
            i += 2;
        }
        return ans;
    }


    private String decodeString(String s) {
        List<Integer> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(s, "[]", false);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            String regEx = "[^0-9]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(token);
            String num = m.replaceAll("");
            l1.add(Integer.parseInt(num));
            l2.add(token.replace(num, ""));
        }
        return Arrays.stream(s.split("]"))
                .map(x -> x.split("\\[")).map(x -> {
                    if (x.length == 1) return x[0];
                    else {
                        int i = Integer.parseInt(x[0]);
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < i; j++) {
                            sb.append(x[1]);
                        }
                        return sb.toString();
                    }
                }).reduce((x, y) -> x + y).orElse("");
    }

    int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) map.merge(s.charAt(i), 1, (a, b) -> a + b);
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            if (entry.getKey() == 1) return s.indexOf(entry.getKey());
        return -1;
    }

    boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.merge(magazine.charAt(i), 1, (a, b) -> a + b);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            Integer integer = map.get(c);
            if (integer == null || integer == 0) return false;
            else map.put(c, integer - 1);
        }
        return true;
    }

}
