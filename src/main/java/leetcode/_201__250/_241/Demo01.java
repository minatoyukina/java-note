package leetcode._201__250._241;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(diffWaysToCompute("2-1-1"));
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }

    private List<Integer> diffWaysToCompute(String input) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < '0' || c > '9') {
                index.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        if (index.isEmpty()) {
            res.add(Integer.parseInt(input));
            return res;
        }
        for (int i : index) {
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));
            char c = input.charAt(i);
            for (int x : left) {
                for (int y : right) {
                    res.add(c == '+' ? x + y : (c == '-' ? x - y : x * y));
                }
            }
        }
        return res;
    }

}