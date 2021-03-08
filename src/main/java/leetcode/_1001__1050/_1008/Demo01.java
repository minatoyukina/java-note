package leetcode._1001__1050._1008;

import leetcode._51__100._100.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
    }

    private TreeNode bstFromPreorder(int[] preorder) {
        List<Integer> list = new ArrayList<>();
        for (int i : preorder) list.add(i);
        TreeNode node = new TreeNode(preorder[0]);
        dfs(node, list);
        return node;
    }

    private void dfs(TreeNode head, List<Integer> list) {
        if (list.size() > 0) {
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            int val = list.get(0);
            for (int i : list) {
                if (i > val) right.add(i);
                if (i < val) left.add(i);
            }
            if (left.size() > 0) {
                head.left = new TreeNode(left.get(0));
                dfs(head.left, left);
            }
            if (right.size() > 0) {
                head.right = new TreeNode(right.get(0));
                dfs(head.right, right);
            }
        }
    }
}
