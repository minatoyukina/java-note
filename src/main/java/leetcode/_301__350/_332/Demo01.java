package leetcode._301__350._332;

import javafx.util.Pair;
import leetcode.util.Common;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findItinerary(Common.strToList(
                "[[\"EZE\",\"AXA\"],[\"TIA\",\"ANU\"],[\"ANU\",\"JFK\"],[\"JFK\",\"ANU\"]," +
                        "[\"ANU\",\"EZE\"],[\"TIA\",\"ANU\"],[\"AXA\",\"TIA\"],[\"TIA\",\"JFK\"]," +
                        "[\"ANU\",\"TIA\"],[\"JFK\",\"TIA\"]]")));
    }

    private List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<Pair<Integer, String>>> map = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
            List<String> ticket = tickets.get(i);
            List<Pair<Integer, String>> list = map.getOrDefault(ticket.get(0), new ArrayList<>());
            list.add(new Pair<>(i, ticket.get(1)));
            map.put(ticket.get(0), list);
        }
        map.forEach((x, y) -> y.sort((a, b) -> a.getValue().compareTo(b.getValue())));
        List<String> list = new ArrayList<>();
        list.add("JFK");
        return dfs(map, tickets.size(), new HashSet<>(), list);
    }

    private List<String> dfs(Map<String, List<Pair<Integer, String>>> map, int size, Set<Integer> visited, List<String> list) {
        if (visited.size() == size) return list;
        String start = list.get(list.size() - 1);
        List<Pair<Integer, String>> pairList = map.getOrDefault(start, new ArrayList<>());
        for (Pair<Integer, String> entry : pairList) {
            if (visited.contains(entry.getKey())) continue;
            visited.add(entry.getKey());
            list.add(entry.getValue());
            List<String> dfs = dfs(map, size, visited, list);
            if (dfs != null) return dfs;
            visited.remove(entry.getKey());
            list.remove(list.size() - 1);
        }
        return null;
    }

}