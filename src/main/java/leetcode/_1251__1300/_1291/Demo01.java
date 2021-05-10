package leetcode._1291;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(sequentialDigits(100, 300));
        System.out.println(sequentialDigits(1000, 13000));
        System.out.println(sequentialDigits(10, 1000000000));
    }

    private List<Integer> sequentialDigits(int low, int high) {
        List<Long> list = new ArrayList<>();
        int lo = String.valueOf(low).length();
        int hi = String.valueOf(high).length();
        for (int i = lo; i <= hi; i++) {
            for (int j = 1; j <= 10 - lo; j++) {
                int x = j;
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < i; k++) {
                    sb.append(x++);
                }
                if (x > 10) break;
                list.add(Long.parseLong(sb.toString()));
            }
        }
        return list.stream().filter(s -> s >= low && s <= high).map(Long::intValue).collect(Collectors.toList());
    }

}
