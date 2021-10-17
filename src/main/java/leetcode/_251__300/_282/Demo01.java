package leetcode._251__300._282;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(addOperators("123", 6));
    }

    private List<String> addOperators(String num, int target) {
        List<List<Pair<Integer, Character>>> list = new ArrayList<>();
        dfs(num, target, 0, 0, 1, new ArrayList<>(), list);
        List<String> ans = new ArrayList<>();
        for (List<Pair<Integer, Character>> pairs : list) {
            StringBuilder sb = new StringBuilder(num);
            int n = 0;
            for (Pair<Integer, Character> pair : pairs) {
                sb.insert(pair.getKey() + n++, pair.getValue());
            }
            ans.add(sb.toString());
        }
        return ans;
    }


    private void dfs(String num, int target, int pos, int res, int pre, List<Pair<Integer, Character>> cur,
                     List<List<Pair<Integer, Character>>> list) {
        if (pos >= num.length()) {
            if (res == target) list.add(cur);
            return;
        }
        for (int i = pos + 1; i <= num.length(); i++) {
            int x = Integer.parseInt(num.substring(pos, i));
            ArrayList<Pair<Integer, Character>> c1 = new ArrayList<>(cur);
            ArrayList<Pair<Integer, Character>> c2 = new ArrayList<>(cur);
            ArrayList<Pair<Integer, Character>> c3 = new ArrayList<>(cur);
            c1.add(new Pair<>(i, '+'));
            c2.add(new Pair<>(i, '-'));
            c3.add(new Pair<>(i, '*'));
            dfs(num, target, i, res + x, x, c1, list);
            dfs(num, target, i, res - x, x, c2, list);
            dfs(num, target, i, res, pre * x, c3, list);
        }
    }

}