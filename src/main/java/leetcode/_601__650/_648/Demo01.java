package leetcode._601__650._648;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        System.out.println(replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the"));
    }

    private String replaceWords(List<String> dict, String sentence) {
        List<String> list = dict.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        String[] split = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String s : split)
            for (int i = 0; i < list.size(); i++)
                if (s.startsWith(list.get(i))) {
                    sb.append(list.get(i)).append(" ");
                    break;
                } else if (i == list.size() - 1) sb.append(s).append(" ");
        return sb.toString().trim();
    }


}
