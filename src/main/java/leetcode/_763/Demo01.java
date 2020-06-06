package leetcode._763;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("caedbdedda"));
        System.out.println(partitionLabels("eaaaabaaec"));
    }

    private List<Integer> partitionLabels(String S) {
        Map<Character, int[]> map = new HashMap<>();
        char[] chars = S.toCharArray();
        for (char c : chars) {
            int i = S.indexOf(c);
            int j = S.lastIndexOf(c);
            map.put(c, new int[]{i, j});
        }
        List<int[]> list = new ArrayList<>(map.values());
        return merge(list).stream().sorted(Comparator.comparingInt(x -> x[0])).map(s -> s[1] - s[0] + 1).collect(Collectors.toList());
    }

    private List<int[]> merge(List<int[]> intervals) {
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                if (isOverlay(intervals.get(i), intervals.get(j))) {
                    int[] y = intervals.get(j);
                    y[0] = Math.min(intervals.get(i)[0], intervals.get(j)[0]);
                    y[1] = Math.max(intervals.get(i)[1], intervals.get(j)[1]);
                    int[] x = intervals.get(i);
                    x[0] = 0;
                    x[1] = -1;
                }
            }
        }
        return intervals.stream().filter(s -> s[0] <= s[1]).collect(Collectors.toList());

    }

    private boolean isOverlay(int[] a, int[] b) {
        return (a[0] <= b[0] && a[1] >= b[1])
                || (a[0] >= b[0] && a[0] <= b[1])
                || (a[1] >= b[0] && a[1] <= b[1]);
    }

}
