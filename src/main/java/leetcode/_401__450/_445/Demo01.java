package leetcode._401__450._445;

import leetcode._1__50._2.ListNode;
import leetcode.util.Common;
import org.junit.Test;

import java.math.BigInteger;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(addTwoNumbers(
                Common.arrayToNode(new int[]{7, 2, 4, 5}),
                Common.arrayToNode(new int[]{5, 6, 4}))
        );
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        while (l1 != null) {
            s1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.append(l2.val);
            l2 = l2.next;
        }
        String s = new BigInteger(s1.toString()).add(new BigInteger(s2.toString())).toString();
        String[] split = String.valueOf(s).split("");
        ListNode node = new ListNode(Integer.parseInt(split[0]));
        ListNode tmp = node;
        for (int i = 1; i < split.length; i++) {
            tmp.next = new ListNode(Integer.parseInt(split[i]));
            tmp = tmp.next;
        }
        return node;
    }

}
