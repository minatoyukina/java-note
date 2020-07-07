package leetcode._851__900._870;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
        System.out.println(Arrays.toString(advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
        System.out.println(Arrays.toString(advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2})));
    }

    private int[] advantageCount(int[] A, int[] B) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        for (int i = 0, x = 0; i < B.length; i++) pairs.add(new Pair<>(B[i], x++));
        List<Integer> list = pairs.stream()
                .sorted(Comparator.comparingInt(Pair::getKey))
                .map(Pair::getValue)
                .collect(Collectors.toList());
        Arrays.sort(A);
        int index = 0;
        int[] ans = new int[A.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (Integer i : list) {
            while (index < B.length && A[index] <= B[i]) {
                stack.push(A[index]);
                index++;
            }
            if (index < B.length && A[index] > B[i]) {
                ans[i] = A[index];
                index++;
            }
        }
        for (int i = 0; i < ans.length; i++) if (ans[i] == -1) ans[i] = stack.pop();
        return ans;
    }

}
