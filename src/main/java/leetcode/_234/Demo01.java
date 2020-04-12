package leetcode._234;

import leetcode._1__50._2.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        ListNode node = new ListNode(1, new ListNode(3, new ListNode(3, new ListNode(1))));
        System.out.println(isPalindrome(node));
    }

    private boolean isPalindrome(ListNode head) {
        ListNode tmp = head;
        List<Integer> list = new ArrayList<>();
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - i - 1))) return false;
        }
        return true;
    }
}
