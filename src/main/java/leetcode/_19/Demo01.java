package leetcode._19;

import leetcode._2.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(node, 1));
        System.out.println(removeNthFromEnd(node, 2));
    }

    private ListNode removeNthFromEnd(ListNode head, int n) {
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        while (head.next != null) {
            list.add(head.next.val);
            head = head.next;
        }
        list.remove(list.size() - n);
        if (list.isEmpty()) {
            return null;
        }
        ListNode node = new ListNode(list.get(0));
//        ListNode tmp = node;
//        int i = 1;
//        while (tmp.next == null) {
//            tmp.next = new ListNode(list.get(i++));
//            tmp = tmp.next;
//            if (i == list.size()) {
//                break;
//            }
//        }
        listToNode(list, node, 1);
        return node;
    }

    private void listToNode(List<Integer> list, ListNode node, int i) {
        if (i >= list.size()) {
            return;
        }
        node.next = new ListNode(list.get(i++));
        listToNode(list, node.next, i);
    }


}
