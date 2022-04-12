package leetcode._2001__2050._2048;

import org.junit.Test;

import java.util.*;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(nextBeautifulNumber(666666));
        System.out.println(nextBeautifulNumber(3000));
    }

    public int nextBeautifulNumber(int n) {
        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(1, 22, 333, 4444, 55555, 666666, 1224444));
        dfs(new int[]{2, 2, 1}, new HashSet<>(), new StringBuilder(), set);
        dfs(new int[]{3, 3, 3, 1}, new HashSet<>(), new StringBuilder(), set);
        dfs(new int[]{4, 4, 4, 4, 1}, new HashSet<>(), new StringBuilder(), set);
        dfs(new int[]{3, 3, 3, 2, 2}, new HashSet<>(), new StringBuilder(), set);
        dfs(new int[]{5, 5, 5, 5, 5, 1}, new HashSet<>(), new StringBuilder(), set);
        dfs(new int[]{4, 4, 4, 4, 2, 2}, new HashSet<>(), new StringBuilder(), set);
        dfs(new int[]{3, 3, 3, 2, 2, 1}, new HashSet<>(), new StringBuilder(), set);
        return Optional.ofNullable(set.higher(n)).orElse(-1);
    }

    private void dfs(int[] arr, Set<Integer> visited, StringBuilder sb, Set<Integer> set) {
        if (sb.length() == arr.length) {
            set.add(Integer.parseInt(sb.toString()));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                dfs(arr, visited, sb.append(arr[i]), set);
                sb.deleteCharAt(sb.length() - 1);
                visited.remove(i);
            }
        }
    }


}
