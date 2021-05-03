package leetcode.lcci;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1707 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(trulyMostPopular(
                new String[]{"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"},
                new String[]{"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)", "(a,aa)"})));


    }

    private Map<String, String> parent = new HashMap<>();
    private Map<String, Integer> count = new HashMap<>();

    private String[] trulyMostPopular(String[] names, String[] synonyms) {
        for (String name : names) {
            String[] split = name.split("\\(");
            String str = split[0];
            int i = Integer.parseInt(split[1].substring(0, split[1].length() - 1));
            parent.put(str, str);
            count.put(str, i);
        }
        for (String synonym : synonyms) {
            String[] split = synonym.substring(1, synonym.length() - 1).split(",");
            for (String s : split) {
                if (!parent.containsKey(s)) {
                    parent.put(s, s);
                    count.put(s, 0);
                }
            }
            union(split[0], split[1]);
        }
        return count.entrySet().stream().filter(t -> t.getValue() > 0 && find(t.getKey()).equals(t.getKey()))
                .map(s -> s.getKey() + "(" + s.getValue() + ")").toArray(String[]::new);
    }

    private String find(String s) {
        if (parent.get(s).equals(s)) return s;
        parent.put(s, find(parent.get(s)));
        return parent.get(s);
    }

    private void union(String x, String y) {
        String s1 = find(x);
        String s2 = find(y);
        if (s1.equals(s2)) return;
        if (s1.compareTo(s2) > 0) {
            parent.put(s1, s2);
            count.put(s2, count.get(s1) + count.get(s2));
        } else {
            parent.put(s2, s1);
            count.put(s1, count.get(s1) + count.get(s2));
        }
    }
}
