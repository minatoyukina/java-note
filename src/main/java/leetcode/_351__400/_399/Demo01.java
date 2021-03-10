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
                        Lists.newArrayList("x", "x")
                )
        )));
    }

    private double[] div;
    private double[] values;

    private double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        this.values = values;
        Set<String> set = new TreeSet<>();
        for (List<String> equation : equations) {
            set.addAll(equation);
        }
        List<String> list = new ArrayList<>(set);
        int[] parent = new int[set.size()];
        div = new double[set.size()];
        for (int i = 0; i < set.size(); i++) {
            parent[i] = i;
            div[i] = 1;
        }
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String x = equation.get(0);
            String y = equation.get(1);
            if (x.compareTo(y) > 0) {
                String tmp = x;
                x = y;
                y = tmp;
                values[i] = 1 / values[i];
            }
            merge(parent, list.indexOf(x), list.indexOf(y));
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String x = query.get(0);
            String y = query.get(1);
            if (x.compareTo(y) < 0) {
                String tmp = x;
                x = y;
                y = tmp;
            }
            if (!set.contains(x) || !set.contains(y)) {
                res[i] = -1;
                continue;
            }
            int index = list.indexOf(x);
            double v = div[index];
            while (parent[index] != index) {
                index = parent[index];
                v /= div[index];
            }
            res[i] = v;
        }

        return res;
    }

    private int find(int[] arr, int x) {
        if (arr[x] == x) return x;
        else {
            div[x] /= values[x];
            return arr[x] = find(arr, arr[x]);
        }
    }

    private void merge(int arr[], int i, int j) {
        int x = find(arr, i);
        int y = find(arr, j);
        if (x == y) return;
        arr[y] = x;
    }
}