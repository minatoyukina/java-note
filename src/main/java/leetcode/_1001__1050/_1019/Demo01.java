package leetcode._1001__1050._1019;

import leetcode._1__50._2.ListNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(nextLargerNodes(
                Common.arrayToNode(new int[]{2, 7, 4, 3, 5}))));
        System.out.println(Arrays.toString(nextLargerNodes(
                Common.arrayToNode(new int[]{1, 7, 5, 1, 9, 2, 5, 1}))));
    }

    private int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) > list.get(i)) {
                    ans[i] = list.get(j);
                    break;
                }
                if (j == list.size() - 1) ans[i] = 0;
            }
        }
        return ans;
    }

}
