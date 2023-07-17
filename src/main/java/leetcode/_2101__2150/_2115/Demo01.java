package leetcode._2101__2150._2115;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(findAllRecipes(new String[]{"bread", "sandwich"}, Arrays.asList(Arrays.asList("yeast", "flour"), Arrays.asList("bread",
                "meat")), new String[]{"yeast", "flour", "meat"}));
        System.out.println(findAllRecipes(new String[]{"bread"}, Collections.singletonList(Arrays.asList("yeast", "flour")), new String[]{"yeast"}));
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> sSet = Arrays.stream(supplies).collect(Collectors.toSet());
        Set<String> rSet = Arrays.stream(recipes).collect(Collectors.toSet());
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Set<String>> edge = new HashMap<>();
        Set<String> endPoint = new ConcurrentSkipListSet<>();
        for (int i = 0; i < recipes.length; i++) {
            List<String> list = ingredients.get(i);
            map.putIfAbsent(recipes[i], list);
            for (String s : list) if (rSet.contains(s)) edge.computeIfAbsent(s, k -> new HashSet<>()).add(recipes[i]);
            if (sSet.containsAll(list)) endPoint.add(recipes[i]);
        }
        Set<String> ans = new HashSet<>(endPoint);
        while (true) {
            int size = ans.size();
            for (String s : endPoint) {
                Set<String> set = edge.getOrDefault(s, Collections.emptySet());
                for (String ss : set) {
                    if (map.get(ss).stream().allMatch(t -> ans.contains(t) || sSet.contains(t))) {
                        ans.add(ss);
                        endPoint.add(ss);
                    }
                }
                endPoint.remove(s);
            }
            if (ans.size() == size) break;
        }
        return new ArrayList<>(ans);
    }

}
