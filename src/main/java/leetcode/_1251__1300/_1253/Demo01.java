package leetcode._1251__1300._1253;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(reconstructMatrix(5, 5, new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1}));
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        for (int i : colsum) {
            if (i == 2) {
                if (upper <= 0 || lower <= 0) return Collections.emptyList();
                l1.add(1);
                l2.add(1);
                upper--;
                lower--;
            } else if (i == 0) {
                l1.add(0);
                l2.add(0);
            } else {
                if (upper > 0 || lower > 0) {
                    if (upper >= lower) {
                        l1.add(1);
                        l2.add(0);
                        upper--;
                    } else {
                        l1.add(0);
                        l2.add(1);
                        lower--;
                    }
                } else return Collections.emptyList();
            }
        }
        return upper == 0 && lower == 0 ? lists : Collections.emptyList();
    }

}