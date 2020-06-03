package leetcode._752;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
    }

    private int openLock(String[] deadends, String target) {
        int count = 0;
        List<String>[] lists = new ArrayList[4];
        for (int i = 0; i < 4; i++) lists[i] = new ArrayList<>();
        Arrays.stream(deadends).map(s -> s.split("")).forEach(t -> IntStream.range(0, t.length).forEach(i -> lists[i].add(t[i])));
        char[] chars = target.toCharArray();
        for (int i = 0; i < lists.length; i++) {
            Collections.sort(lists[i]);
            int a = Integer.parseInt(lists[i].get(0));
            int b = Integer.parseInt(lists[i].get(lists[i].size() - 1));
            int c = Integer.parseInt(String.valueOf(chars[i]));
            if (a >= c) count += c;
            else if (b <= c) count += 10 - c;
            else return -1;
        }
        return count;
    }

}
