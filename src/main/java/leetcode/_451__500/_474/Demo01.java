package leetcode._451__500._474;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(makesquare(new int[]{5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4}));
        System.out.println(makesquare(new int[]{1, 1, 2, 2, 2}));
    }

    private boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i : matchsticks) sum += i;
        if (matchsticks.length < 4 || sum % 4 != 0) return false;
        matchsticks = IntStream.of(matchsticks).boxed().sorted((x, y) -> y - x).mapToInt(x -> x).toArray();
        int l = sum / 4;
        for (int i : matchsticks) if (i > l || (i < l && i + matchsticks[matchsticks.length - 1] > l)) return false;
        return dfs(matchsticks, new HashSet<>(), 0, 0, l);
    }

    private boolean dfs(int[] arr, Set<Integer> visited, int count, int sum, int l) {
        if (count > 4 || sum > l) return false;
        if (sum == l) {
            sum = 0;
            count++;
        }
        if (visited.size() == arr.length && count == 4) return true;
        for (int i = 0; i < arr.length; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                if (dfs(arr, visited, count, sum + arr[i], l)) return true;
                visited.remove(i);
            }
        }
        return false;
    }

}
