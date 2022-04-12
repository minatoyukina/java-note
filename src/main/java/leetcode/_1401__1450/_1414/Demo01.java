package leetcode._1401__1450._1414;

import org.junit.Test;

import java.util.Optional;
import java.util.TreeSet;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findMinFibonacciNumbers(645157245));
    }

    public int findMinFibonacciNumbers(int k) {
        int[] arr = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903};
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr) set.add(i);
        int ans = 1;
        while (!set.contains(k)) {
            k -= Optional.ofNullable(set.lower(k)).orElse(0);
            ans++;
        }
        return ans;
    }


}