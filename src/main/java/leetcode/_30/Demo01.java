package leetcode._30;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("", new String[]{}));
        System.out.println(findSubstring("ababaab", new String[]{"ab", "ba", "ba"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
    }

    private List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (words.length == 0) {
            return list;
        }
        int sum = Arrays.stream(words).mapToInt(String::length).sum();
        int length = words[0].length();
        for (int i = 0; i < s.length() - sum + 1; i++) {
            String substring = s.substring(i, i + sum);
            List<String> subList = new ArrayList<>();
            for (int j = 0; j < substring.length(); j = j + length) {
                subList.add(substring.substring(j, j + length));
            }
            if (subList.stream().sorted().collect(Collectors.toList())
                    .equals(Arrays.stream(words).sorted().collect(Collectors.toList()))) {
                list.add(i);
            }
        }
        return list;
    }

    //全排列
    private void permute(Map<String, List<String>> map, List<String> words) {
        if (map.size() == 0) {
            for (String word : words) {
                List<String> tmp = new CopyOnWriteArrayList<>(words);
                tmp.remove(word);
                map.put(word, tmp);
            }
        }
        map.forEach((x, y) -> {
            if (y.size() > 0) {
                map.remove(x);
                for (String s : y) {
                    String str = x;
                    CopyOnWriteArrayList<String> copy = new CopyOnWriteArrayList<>(y);
                    str += s;
                    copy.remove(s);
                    map.put(str, copy);
                    permute(map, copy);
                }
            }
        });
    }

}
