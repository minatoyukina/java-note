package leetcode._651__700._677;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class MapSum {

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));

    }

    private Map<String, Integer> map;

    public MapSum() {
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        return map.entrySet().stream()
                .filter(s -> s.getKey().startsWith(prefix))
                .mapToInt(Map.Entry::getValue).sum();
    }
}
