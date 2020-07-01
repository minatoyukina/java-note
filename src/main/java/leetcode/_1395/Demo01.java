package leetcode._1395;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numTeams(new int[]{2, 5, 3, 4, 1}));
        System.out.println(numTeams(new int[]{1, 2, 3, 4}));
    }


    private int numTeams(int[] rating) {
        List<Pair<Boolean, List<Integer>>> list = new CopyOnWriteArrayList<>();
        for (int i : rating) {
            List<Integer> l1 = new ArrayList<>();
            l1.add(i);
            Pair<Boolean, List<Integer>> p1 = new Pair<>(true, l1);
            Pair<Boolean, List<Integer>> p2 = new Pair<>(false, new ArrayList<>(l1));
            list.add(p1);
            list.add(p2);
            for (Pair<Boolean, List<Integer>> pair : list) {
                List<Integer> value = pair.getValue();
                if (pair.getKey() && value.get(value.size() - 1) > i && value.size() <= 2) {
                    List<Integer> copy = new ArrayList<>(value);
                    copy.add(i);
                    list.add(new Pair<>(true, copy));
                }
                if (!pair.getKey() && value.get(value.size() - 1) < i && value.size() <= 2) {
                    List<Integer> copy = new ArrayList<>(value);
                    copy.add(i);
                    list.add(new Pair<>(false, copy));
                }
            }
        }
        return (int) list.stream()
                .map(Pair::getValue).filter(x -> x.size() == 3)
                .count();
    }
}
