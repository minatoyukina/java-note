package leetcode._801__850._811;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

    private List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] split = s.split(" ");
            int x = Integer.parseInt(split[0]);
            String ss = "." + split[1];
            for (int i = 0; i < ss.length(); i++) {
                char c = ss.charAt(i);
                if (c == '.') {
                    String s1 = ss.substring(i + 1);
                    map.put(s1, map.getOrDefault(s1, 0) + x);
                }
            }
        }
        return map.entrySet().stream().map(x -> x.getValue() + " " + x.getKey()).collect(Collectors.toList());
    }

}