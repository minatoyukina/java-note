package leetcode._401__450._401;

import org.junit.Test;

import java.util.*;
import java.util.function.BiFunction;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(new TreeSet<>(readBinaryWatch(5)));
        System.out.println(readBinaryWatch(0));
    }

    private List<String> readBinaryWatch(int num) {
        Map<Integer, List<Integer>> h = new HashMap<>(7);
        h.put(0, Collections.singletonList(0));
        h.put(1, Arrays.asList(1, 2, 4, 8));
        h.put(2, Arrays.asList(3, 5, 9, 6, 10));
        h.put(3, Arrays.asList(7, 11));
        Map<Integer, List<Integer>> m = new HashMap<>(9);
        m.put(0, Collections.singletonList(0));
        int[] arr = {1, 2, 4, 8, 16, 32};
        BiFunction<List<Integer>, List<Integer>, List<Integer>> function = (x, y) -> {
            y.addAll(x);
            return y;
        };
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(arr[i]);
            m.merge(1, list1, function);
            if (i >= 2) {
                List<Integer> list5 = new ArrayList<>();
                list5.add(63 - arr[i]);
                m.merge(5, list5, function);
            }
            for (int j = i + 1; j < arr.length; j++) {
                List<Integer> list2 = new ArrayList<>();
                list2.add(arr[i] + arr[j]);
                if (63 - arr[i] - arr[j] < 60) {
                    List<Integer> list4 = new ArrayList<>();
                    list4.add(63 - arr[i] - arr[j]);
                    m.merge(4, list4, function);

                }
                m.merge(2, list2, function);
                for (int k = j + 1; k < arr.length; k++) {
                    List<Integer> list3 = new ArrayList<>();
                    list3.add(arr[i] + arr[j] + arr[k]);
                    m.merge(3, list3, function);
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            int min = num - i;
            if (min >= 6 || min < 0) continue;
            List<Integer> list1 = h.get(i);
            List<Integer> list2 = m.get(min);
            for (Integer x : list1) {
                for (Integer y : list2) {
                    list.add(x + ":" + (y < 10 ? "0" + y : y));
                }
            }
        }
        return list;
    }

}