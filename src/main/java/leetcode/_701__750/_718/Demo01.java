package leetcode._701__750._718;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findLength(new int[]{1, 2, 3, 1, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    private int findLength(int[] A, int[] B) {
        List<List<Integer>> l1 = new ArrayList<>();
        List<List<Integer>> l2 = new ArrayList<>();
        List<Integer> a = Arrays.stream(A).boxed().collect(Collectors.toList());
        List<Integer> b = Arrays.stream(B).boxed().collect(Collectors.toList());
        for (int i = 0; i < A.length; i++) {
            if (!b.contains(A[i])) continue;
            for (int j = i + 1; j <= A.length; j++) {
                l1.add(a.subList(i, j));
            }
        }
        for (int i = 0; i < B.length; i++) {
            if (!a.contains(A[i])) continue;
            for (int j = i + 1; j <= B.length; j++) {
                l2.add(b.subList(i, j));
            }
        }
        return l1.stream().filter(l2::contains).mapToInt(List::size).max().orElse(0);
    }


}
