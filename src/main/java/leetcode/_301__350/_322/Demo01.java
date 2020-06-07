package leetcode._301__350._322;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
//        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));

    }

    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int s = list.size();
        for (int i = 0; i < s; i++) {
            System.out.println(list);
            list.remove(list.size() - 1);
        }
    }

    private int coinChange(int[] coins, int amount) {
        int answer = Integer.MAX_VALUE;
        List<Integer> list = Arrays.stream(coins).sorted().boxed().collect(Collectors.toList());
        int s = list.size();
        for (int i = 0; i < s; i++) {
            List<Integer> copy = new ArrayList<>(list);
            int count = r(copy, 0, amount, 0, new ArrayList<>());
            if (count < answer) {
                answer = count;
            }
            list.remove(list.size() - 1);
        }
        return answer;
    }

    private int r(List<Integer> list, int total, int amount, int count, List<Integer> test) {
        int index = list.size() - 1;
        if (index < 0) {
            return -1;
        }
        Integer integer = list.get(index);
        while (total + integer <= amount) {
            total += integer;
            count++;
            test.add(integer);
        }
        if (total == amount) {
            return count;
        } else {

        }
        list.remove(index);
        return r(list, total, amount, count, test);
    }
}
