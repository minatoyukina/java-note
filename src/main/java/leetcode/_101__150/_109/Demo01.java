package leetcode._101__150._109;

import leetcode._51__100._100.TreeNode;
import leetcode._1__50._2.ListNode;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        System.out.println(sortedListToBST(node));
    }

    private TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        TreeNode root = new TreeNode(middle(head).val);
        dfs(root, head);
        return root;
    }

    private ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode pre(ListNode head, ListNode middle) {
        if (head.next == null) return null;
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.next == middle) tmp.next = null;
            tmp = tmp.next;
        }
        return head;
    }

    private void dfs(TreeNode root, ListNode head) {
        ListNode middle = middle(head);
        ListNode left = pre(head, middle);
        ListNode right = middle.next;
        if (left != null) {
            root.left = new TreeNode(middle(left).val);
            dfs(root.left, left);
        }
        if (right != null) {
            root.right = new TreeNode(middle(right).val);
            dfs(root.right, right);
        }
    }
}
