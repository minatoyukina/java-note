package leetcode._51__100._89;

import org.junit.Test;

import java.util.*;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(grayCode(3));
        System.out.println(grayCode(2));
        System.out.println(grayCode(0));
    }

    private List<Integer> grayCode(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(0);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        return dfs(sb, new HashSet<>(Collections.singletonList(0)), list);
    }

    private List<Integer> dfs(StringBuilder sb, Set<Integer> set, List<Integer> list) {
        int pow = (int) Math.pow(2, sb.length());
        if (pow == list.size()) return list;
        for (int i = 0; i < sb.length(); i++) {
            sb.replace(i, i + 1, sb.charAt(i) == '1' ? "0" : "1");
            int parseInt = Integer.parseInt(sb.toString(), 2);
            if (!set.contains(parseInt)) {
                set.add(parseInt);
                list.add(parseInt);
                List<Integer> dfs = dfs(sb, set, list);
                if (dfs.size() == pow) return dfs;
            }
            sb.replace(i, i + 1, sb.charAt(i) == '1' ? "0" : "1");
        }
        return new ArrayList<>();
    }
}
