package leetcode._351__400._399;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(calcEquation(
                Lists.newArrayList(
                        Lists.newArrayList("a", "b"),
                        Lists.newArrayList("e", "f"),
                        Lists.newArrayList("b", "e")
                ),
                new double[]{3.4, 1.4, 2.3},
                Lists.newArrayList(
                        Lists.newArrayList("b", "a"),
                        Lists.newArrayList("a", "f"),
                        Lists.newArrayList("f", "f"),
                        Lists.newArrayList("e", "e"),
                        Lists.newArrayList("c", "c"),
                        Lists.newArrayList("a", "c"),
                        Lists.newArrayList("f", "e")
                )
        )));
        System.out.println(Arrays.toString(calcEquation(
                Lists.newArrayList(Lists.newArrayList("a", "b"), Lists.newArrayList("b", "c")),
                new double[]{2.0, 3.0},
                Lists.newArrayList(
                        Lists.newArrayList("a", "c"),
                        Lists.newArrayList("b", "a"),
                        Lists.newArrayList("a", "e"),
                        Lists.newArrayList("a", "a"),
                        Lists.newArrayList("x", "a")
                )
        )));
    }


    private double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            Map<String, Double> sub1 = map.getOrDefault(a, new HashMap<>());
            sub1.put(b, values[i]);
            map.put(a, sub1);

            Map<String, Double> sub2 = map.getOrDefault(b, new HashMap<>());
            sub2.put(a, 1 / values[i]);
            map.put(b, sub2);

        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            if (!map.containsKey(a) || !map.containsKey(b)) res[i] = -1;
            else if (a.equals(b)) res[i] = 1;
            else res[i] = dfs(map, a, b, 1, new HashSet<>());
        }
        return res;
    }

    private double dfs(Map<String, Map<String, Double>> map, String src, String target, double relay, Set<String> memo) {
        Map<String, Double> sub = map.get(src);
        if (src.equals(target)) return relay;
        if (sub == null) return -1;
        for (Map.Entry<String, Double> entry : sub.entrySet()) {
            if (!memo.contains(entry.getKey())) {
                memo.add(entry.getKey());
                double dfs = dfs(map, entry.getKey(), target, relay * entry.getValue(), memo);
                if (dfs != -1) return dfs;
            }
        }
        return -1;
    }
}