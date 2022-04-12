package leetcode._1951__2000._1994;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numberOfGoodSubsets(new int[]{5, 10, 1, 26, 24, 21, 24, 23, 11, 12, 27, 4, 17, 16, 2, 6, 1, 1, 6, 8, 13, 30, 24, 20, 2, 19}));
        System.out.println(numberOfGoodSubsets(new int[]{1, 1, 2, 3, 4}));
    }

    public int numberOfGoodSubsets(int[] nums) {
        Map<String, Long> map = Arrays.stream(nums)
                .filter(s -> !ng.contains(s)).mapToObj(String::valueOf)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Set<String> set = new HashSet<>();
        dfs(2, new HashSet<>(), new StringBuilder(), set);
        int ans = 0, mod = (int) (1e9 + 7), cnt1 = map.getOrDefault("1", 0L).intValue();
        for (String s : set) {
            String[] split = s.split(",");
            long prod = 1;
            for (String ss : split) {
                prod *= map.getOrDefault(ss, 0L) % mod;
                prod %= mod;
            }
            int tmp = cnt1;
            while (tmp-- > 0) prod = prod * 2 % mod;
            ans += prod % mod;
            ans %= mod;
        }
        return ans;
    }

    int[] arr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    List<Integer> ng = Arrays.asList(4, 8, 9, 12, 16, 18, 20, 24, 25, 27, 28);


    private void dfs(int pos, Set<Integer> factors, StringBuilder s, Set<String> set) {
        label:
        for (int i = pos; i <= 30; i++) {
            if (ng.contains(i)) continue;
            HashSet<Integer> f = new HashSet<>(factors);
            for (int x : arr) {
                if (i % x == 0) {
                    if (f.contains(x)) continue label;
                    f.add(x);
                }
            }
            StringBuilder ss = new StringBuilder(s).append(i).append(",");
            set.add(ss.toString());
            dfs(i + 1, f, ss, set);
        }
    }
}