package leetcode._49;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{"", "c"}));
        System.out.println(groupAnagrams(new String[]{"cc", "cc"}));
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        Map<List<String>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            List<String> tmp = Arrays.stream(str.split("")).sorted().collect(Collectors.toList());
            if (!map.containsKey(tmp)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(tmp, list);
            } else {
                map.get(tmp).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

}
