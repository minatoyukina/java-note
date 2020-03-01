package leetcode._2;

import org.junit.Test;

import java.math.BigDecimal;

public class Demo01 {

    @Test
    public void test() {
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);
        System.out.println(addTwoNumbers(a, b));
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String a = nodeToString("", l1), b = nodeToString("", l2);
        String c = new BigDecimal(a).add(new BigDecimal(b)).toString();
        ListNode node = new ListNode(Integer.parseInt(c.charAt(c.length() - 1) + ""));
        stringToNode(node, c);
        return node;
    }

    private void stringToNode(ListNode pre, String str) {
        String s = str.substring(0, str.length() - 1);
        if (!s.isEmpty()) {
            pre.next = new ListNode(Integer.parseInt(s.charAt(s.length() - 1) + ""));
            stringToNode(pre.next, s);
        }
    }

    private String nodeToString(String str, ListNode l) {
        if (l.next == null) {
            return l.val + str;
        } else {
            return nodeToString(l.val + str, l.next);
        }
    }
}
