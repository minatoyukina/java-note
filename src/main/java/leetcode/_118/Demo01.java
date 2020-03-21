package leetcode._118;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(generate(10));
        System.out.println(generate(0));
    }

    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                arrayList.add(1);
            }
            list.add(arrayList);
        }
        for (int i = 1; i < list.size(); i++) {
            for (int j = 1; j < list.get(i).size() - 1; j++) {
                list.get(i).set(j, list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
        }
        return list;
    }
}
