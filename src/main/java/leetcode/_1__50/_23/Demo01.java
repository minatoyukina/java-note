package leetcode._1__50._23;

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
        System.out.println(mergeKLists(new ListNode[]{l1, l2}));
        System.out.println(mergeKLists(new ListNode[0]));
    }

    private ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (ListNode list1 : lists) {
            ListNode tmp = list1;
            while (tmp != null) {
                list.add(tmp.val);
                tmp = tmp.next;
            }
        }
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        if (collect.size() == 0) {
            return null;
        }
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
