package leetcode._1__50._21;

import leetcode._1__50._2.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(mergeTwoLists(l1, l2));
        System.out.println(mergeTwoLists(l1, null));
        System.out.println(mergeTwoLists(null, null));
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        if (l1 == null && l2 == null) {
            return null;
        }
        while (tmp1 != null) {
            list.add(tmp1.val);
            tmp1 = tmp1.next;
        }
        while (tmp2 != null) {
            list.add(tmp2.val);
            tmp2 = tmp2.next;
        }
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        ListNode node = new ListNode(collect.get(0));
        ListNode tmp = node;
        int i = 0;
        while (tmp.next == null && collect.size() > ++i) {
            tmp.next = new ListNode(collect.get(i));
            tmp = tmp.next;
        }
        return node;
    }
}
