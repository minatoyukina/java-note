package leetcode.lcci;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1707 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(trulyMostPopular(
                new String[]{"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"},
                new String[]{"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)", "(Johnny,aa)"})));


    }

    private String[] trulyMostPopular(String[] names, String[] synonyms) {
        List<Set<String>> list = new ArrayList<>();
        Map<String, List<Integer>> listMap = new HashMap<>();
        for (int i = 0, synonymsLength = synonyms.length; i < synonymsLength; i++) {
            String synonym = synonyms[i];
            String[] split = synonym.substring(1, synonym.length() - 1).split(",");
            for (String s : split) {
                List<Integer> count = listMap.getOrDefault(s, new ArrayList<>());
                count.add(i);
                listMap.put(s, count);
            }
            HashSet<String> sub = new HashSet<>(Arrays.asList(split));
            list.add(sub);
        }
        for (int i = 0; i < list.size(); i++) dfs(list, i, listMap, new HashSet<>());
        list = list.stream().filter(s -> s.size() > 0).collect(Collectors.toList());
        Map<String, Integer> map = new HashMap<>();
        for (String name : names) {
            String[] split = name.split("\\(");
            String str = split[0];
            int i = Integer.parseInt(split[1].substring(0, split[1].length() - 1));
            boolean flag = true;
            for (Set<String> strings : list) {
                if (strings.contains(str)) {
                    TreeSet<String> set = new TreeSet<>(strings);
                    map.put(set.first(), map.getOrDefault(set.first(), 0) + i);
                    flag = false;
                    break;
                }
            }
            if (flag) map.put(str, i);
        }
        String[] ans = new String[map.size()];
        int x = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet())
            ans[x++] = entry.getKey() + "(" + entry.getValue() + ")";
        return ans;
    }

    private Set<String> dfs(List<Set<String>> list, int index, Map<String, List<Integer>> map, Set<Integer> memo) {
        Set<String> sub = list.get(index);
        if (memo.contains(index) || sub.isEmpty()) return new HashSet<>();
        memo.add(index);
        List<String> tmp = new ArrayList<>();
        for (String s : sub) {
            if (map.containsKey(s)) {
                List<Integer> integers = map.get(s);
                for (Integer integer : integers) {
                    Set<String> dfs = dfs(list, integer, map, memo);
                    list.set(integer, new TreeSet<>());
                    tmp.addAll(dfs);
                }
            }
        }
        sub.addAll(tmp);
        list.set(index, sub);
        return sub;
    }

}
