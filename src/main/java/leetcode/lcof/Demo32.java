package leetcode.lcof;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.*;

public class Demo32 {

    @Test
    public void test() {
        System.out.println(levelOrder(Common.arrayToTree(1, 2, 3, 4, null, null, 5)));
        System.out.println(levelOrder(Common.arrayToTree(3, 9, 20, null, null, 15, 7)));
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int level = 1;
        ans.add(Collections.singletonList(root.val));
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (level % 2 == 1) {
                    TreeNode node = deque.pollLast();
                    assert node != null;
                    if (node.right != null) {
                        list.add(node.right.val);
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        list.add(node.left.val);
                        deque.offerFirst(node.left);
                    }
                } else {
                    TreeNode node = deque.pollFirst();
                    assert node != null;
                    if (node.left != null) {
                        list.add(node.left.val);
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right.val);
                        deque.offerLast(node.right);
                    }

                }
            }
            if (!list.isEmpty()) ans.add(list);
            level++;
        }
        return ans;
    }
}
