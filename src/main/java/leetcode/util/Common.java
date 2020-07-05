package leetcode.util;

import leetcode._1__50._2.ListNode;

final public class Common {

    public static ListNode arrayToNode(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode tmp = head;
        for (int i = 1; i < arr.length; i++) {
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }
        return head;
    }
}
