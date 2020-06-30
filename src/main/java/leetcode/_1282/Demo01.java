package leetcode._1282;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Integer.parseInt("101", 2));
        System.out.println(groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
        System.out.println(groupThePeople(new int[]{2, 1, 3, 3, 3, 2}));
    }

    private List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> list = new ArrayList<>();
        PriorityQueue<Pair<Integer, List<Integer>>> queue = new PriorityQueue<>((x, y) ->
                Integer.compare(y.getValue().size(), x.getValue().size()));
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> integers = map.get(groupSizes[i]);
            if (integers == null) {
                integers = new ArrayList<>();
            }
            integers.add(i);
            map.put(groupSizes[i], integers);
        }
        map.forEach((x, y) -> queue.add(new Pair<>(x, y)));
        while (!queue.isEmpty()) {
            Pair<Integer, List<Integer>> pair = queue.poll();
            List<Integer> value = pair.getValue();
            Integer key = pair.getKey();
            if (value.size() > key) {
                list.add(new ArrayList<>(value.subList(0, key)));
                Pair<Integer, List<Integer>> sub = new Pair<>(key, new ArrayList<>(value.subList(key, value.size())));
                queue.add(sub);
            } else if (value.size() == key) {
                list.add(value);
            } else {
                int x = value.size();
                while (x < key) {
                    Pair<Integer, List<Integer>> poll = queue.poll();
                    if (poll == null) break;
                    List<Integer> v = poll.getValue();
                    value.addAll(v);
                    x += v.size();
                }
                if (value.size() == key) {
                    list.add(value);
                }
                if (value.size() > key) {
                    list.add(new ArrayList<>(value.subList(0, key)));
                    Pair<Integer, List<Integer>> sub = new Pair<>(key, new ArrayList<>(value.subList(key, value.size())));
                    queue.add(sub);
                }
            }
        }
        return list;
    }
}
