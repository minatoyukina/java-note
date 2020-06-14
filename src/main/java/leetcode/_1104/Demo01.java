package leetcode._1104;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(pathInZigZagTree(8));
        System.out.println(pathInZigZagTree(4));
        System.out.println(pathInZigZagTree(26));
    }

    private List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        while (label != 1) {
            list.add(label);
            int level = (int) (Math.log(label) / Math.log(2) + 1);
            int pow = (int) Math.pow(2, level - 1);
            int i = (int) Math.ceil((label - pow + 1) / 2.0);
            label = pow - i;
        }
        list.add(1);
        Collections.reverse(list);
        return list;
    }
}
