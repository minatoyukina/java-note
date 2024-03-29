package leetcode.util;

import leetcode._1__50._2.ListNode;
import leetcode._51__100._100.TreeNode;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

final public class Common {

    public static ListNode arrayToNode(int... arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode tmp = head;
        for (int i = 1; i < arr.length; i++) {
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }
        return head;
    }


    public static List<Integer> treeToList(TreeNode node) {
        LinkedList<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        list.add(node.val);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                list.add(Optional.ofNullable(poll.left).map(s -> s.val).orElse(null));
                list.add(Optional.ofNullable(poll.right).map(s -> s.val).orElse(null));
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }
        while (list.peekLast() == null) {
            list.pollLast();
        }
        return list;
    }

    public static TreeNode arrayToTree(Integer... arr) {
        TreeNode root;
        TreeNode result = null;
        Queue<TreeNode> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                root = new TreeNode(arr[i]);
                result = root;
                queue.add(root);
            }
            if (!queue.isEmpty()) {
                root = queue.poll();
            } else {
                break;
            }
            assert root != null;
            if (i + 1 < arr.length && arr[i + 1] != null) {
                root.left = new TreeNode(arr[i + 1]);
                queue.add(root.left);
            }
            if (i + 2 < arr.length && arr[i + 2] != null) {
                root.right = new TreeNode(arr[i + 2]);
                queue.add(root.right);
            }
            i = i + 1;
        }
        return result;
    }

    public static List<List<String>> strToList(String s) {
        String[] split = s.substring(2, s.length() - 2).replace("\"", "").split("],\\[");
        return Arrays.stream(split).map(x -> Arrays.stream(x.split(","))
                .collect(Collectors.toList())).collect(Collectors.toList());
    }

    public static int[][] strToArray(String s) {
        return strToList(s).stream()
                .map(x -> x.stream().map(Integer::parseInt).mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }


    @Test
    public void test() {
        TreeNode treeNode = arrayToTree(1, 2, 3, null, 4, null, null, 5, 6);
        System.out.println(treeNode);
        System.out.println(strToList("[[\"EZE\",\"AXA\"],[\"TIA\",\"ANU\"],[\"ANU\",\"JFK\"],[\"JFK\",\"ANU\"],[\"ANU\",\"EZE\"],[\"TIA\",\"ANU\"],[\"AXA\",\"TIA\"],[\"TIA\",\"JFK\"],[\"ANU\",\"TIA\"],[\"JFK\",\"TIA\"]]"));
    }
}
