package leetcode._51__100._99;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        TreeNode node = Common.arrayToTree(1, 3, null, null, 2);
        recoverTree(node);
        System.out.println(node);
    }

    private void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        Integer hi = null, lo = null;
        for (int i = 0; i < list.size(); i++) {
            if ((i == 0 && list.get(i) > list.get(i + 1)) || (i + 1 < list.size() && list.get(i) > list.get(i + 1)) && hi == null) {
                hi = list.get(i);
            }
            if (hi != null && list.get(i) > hi && lo == null) {
                lo = list.get(i - 1);
            }
        }
        if (lo == null) lo = list.get(list.size() - 1);
        dfs(hi, lo, root);
    }

    private void dfs(Integer hi, Integer lo, TreeNode root) {
        if (root == null) return;
        if (hi == root.val) root.val = lo;
        else if (lo == root.val) root.val = hi;
        dfs(hi, lo, root.left);
        dfs(hi, lo, root.right);
    }

    private void dfs(List<Integer> list, TreeNode root) {
        if (root == null) return;
        dfs(list, root.left);
        list.add(root.val);
        dfs(list, root.right);
    }

}
