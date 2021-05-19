package leetcode._51__100._93;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(restoreIpAddresses("1111"));
        System.out.println(restoreIpAddresses("155123123123"));
        System.out.println(restoreIpAddresses("25525511135"));
    }

    private List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(String s, int index, List<Integer> list, List<String> ans) {
        if (list.size() > 4) return;
        if (index >= s.length()) {
            if (list.size() == 4) {
                StringBuilder sb = new StringBuilder(s);
                int x = 0;
                for (int i = 0; i < list.size() - 1; i++) sb.insert(list.get(i) + x++, '.');
                ans.add(sb.toString());
            }
            return;
        }
        if (s.charAt(index) == '0') {
            list.add(index + 1);
            dfs(s, index + 1, list, ans);
        } else {
            int x = index;
            while (x < s.length()) {
                int i = Integer.parseInt(s.substring(index, x + 1));
                if (i > 255) break;
                List<Integer> copy = new ArrayList<>(list);
                copy.add(x + 1);
                dfs(s, x + 1, copy, ans);
                x++;
            }
        }
    }
}
