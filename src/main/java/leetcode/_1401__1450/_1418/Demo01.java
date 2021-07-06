package leetcode._1401__1450._1418;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(displayTable(Lists.newArrayList(
                Lists.newArrayList("David", "3", "Ceviche"),
                Lists.newArrayList("Corina", "10", "Beef Burrito"),
                Lists.newArrayList("David", "3", "Fried Chicken"),
                Lists.newArrayList("Carla", "5", "Water"),
                Lists.newArrayList("Carla", "5", "Ceviche"),
                Lists.newArrayList("Rous", "3", "Ceviche")
        )));
    }

    private List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> set = new TreeSet<>();
        Map<Integer, Map<String, Integer>> map = new TreeMap<>();
        for (List<String> order : orders) {
            Integer table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            set.add(food);
            Map<String, Integer> sub = map.getOrDefault(table, new HashMap<>());
            sub.put(food, sub.getOrDefault(food, 0) + 1);
            map.put(table, sub);
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(set);
        ans.add(header);
        for (Map.Entry<Integer, Map<String, Integer>> entry : map.entrySet()) {
            List<String> col = new ArrayList<>();
            col.add(entry.getKey().toString());
            for (String s : set) col.add(entry.getValue().getOrDefault(s, 0).toString());
            ans.add(col);
        }
        return ans;
    }

}