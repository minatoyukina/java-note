package leetcode._101__150._131;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println("a".substring(1));
        System.out.println(partition("aab"));
        System.out.println(partition("a"));
    }

    private List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(ans, s, new ArrayList<>());
        return ans;
    }


    private void dfs(List<List<String>> ans, String s, List<String> list) {
        if (s.isEmpty()) ans.add(new ArrayList<>(list));
        for (int i = 1; i <= s.length(); i++) {
            String ss = s.substring(0, i);
            if (ss.equals(new StringBuilder(ss).reverse().toString())) {
                list.add(ss);
                dfs(ans, s.substring(i), list);
                list.remove(list.size() - 1);
            }
        }
    }
}