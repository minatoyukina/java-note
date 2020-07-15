package leetcode.util;

import leetcode._1__50._2.ListNode;
import leetcode._50__100._100.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

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

    public static TreeNode arrayToTree(String src) {
        src = src.substring(1, src.length() - 1).trim();
        String[] strList = src.split(",");

        TreeNode root;
        TreeNode result = null;
        Queue<TreeNode> queue = new LinkedList<>();
        for (int i = 0; i < strList.length; i++) {
            if (i == 0) {
                root = new TreeNode(Integer.parseInt(strList[i]));
                result = root;
                queue.add(root);
            }
            if (!queue.isEmpty()) {
                root = queue.poll();
            } else {
                break;
            }
            if (i + 1 < strList.length && !strList[i + 1].trim().equals("null")) {
                root.left = new TreeNode(Integer.parseInt(strList[i + 1].trim()));
                queue.add(root.left);
            }
            if (i + 2 < strList.length && !strList[i + 2].trim().equals("null")) {
                root.right = new TreeNode(Integer.parseInt(strList[i + 2].trim()));
                queue.add(root.right);
            }
            i = i + 1;
        }
        return result;
    }


    @Test
    public void test() {
        System.out.println(arrayToTree("[ 1, 2, 3, null, 4, null, null, 5, 6]"));
    }
}
