package leetcode._1401__1450._1447;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(simplifiedFractions(100));
    }

    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (GCD(j, i) == 1) list.add(j + "/" + i);
            }
        }
        return list;
    }

    int GCD(int a, int b) {
        if (b == 0) return a;
        if (a < b) return GCD(b, a);
        else return GCD(b, a % b);
    }

}