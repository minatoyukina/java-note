package leetcode._101__150._142;

import leetcode._1__50._2.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Demo01 {

    @Test
    public void test() {
        ListNode end = new ListNode(-4);
        ListNode node = new ListNode(2, new ListNode(0, end));
        end.next = node;
        System.out.println(detectCycle(new ListNode(3, node)).val);
        System.out.println(Objects.requireNonNull(detectCycle2(new ListNode(3, node))).val);

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2, l1);
        System.out.println(Objects.requireNonNull(detectCycle2(l1)).val);
    }

    private ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head)) return head;
            list.add(head);
            head = head.next;
        }
        return null;
    }

    private ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        if (flag) {
            ListNode ans = head;
            while (slow != null) {
                if (slow == ans) return ans;
                ans = ans.next;
                slow = slow.next;
            }
        }
        return null;
    }
}
