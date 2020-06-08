package leetcode._817;

import leetcode._1__50._2.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        ListNode node = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
        System.out.println(numComponents(node, new int[]{1}));
    }

    private int numComponents(ListNode head, int[] G) {
        Set<Integer> set = Arrays.stream(G).boxed().collect(Collectors.toSet());
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(set.contains(head.val) ? "1" : "0");
            head = head.next;
        }
        return (int) Arrays.stream(sb.toString().split("0")).filter(s -> s.length() > 0).count();
    }


}
