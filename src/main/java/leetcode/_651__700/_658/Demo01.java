package leetcode._651__700._658;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9));
    }

    @SuppressWarnings("all")
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        if (x < arr[0]) return Arrays.stream(arr).limit(k).boxed().collect(Collectors.toList());
        if (x > arr[n - 1]) return Arrays.stream(arr).boxed().collect(Collectors.toList()).subList(n - k, n);
        int pos = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= x) {
                pos = i;
                break;
            }
        }
        int left = pos - 1, right = pos;
        Deque<Integer> list = new LinkedList<>();
        while (list.size() < k) {
            int dl = Integer.MAX_VALUE, dr = Integer.MAX_VALUE;
            if (left >= 0) dl = x - arr[left];
            if (right < n) dr = arr[right] - x;
            if (dr >= dl) list.addFirst(arr[left--]);
            else list.addLast(arr[right++]);
        }
        return (List<Integer>) list;

    }

}