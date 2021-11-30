package leetcode._1101__1150._1110;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(delNodes(Common.arrayToTree(1, 2, 3, 4, 5, 6, 7), new int[]{1, 3, 5}));
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) set.add(i);
        return dfs(root, null, true, set);
    }

    private List<TreeNode> dfs(TreeNode root, TreeNode pre, boolean left, Set<Integer> set) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) return list;
        if (set.contains(root.val)) {
            if (pre != null) {
                if (left) pre.left = null;
                else pre.right = null;
            }
            list.addAll(dfs(root.left, null, true, set));
            list.addAll(dfs(root.right, null, false, set));
        } else {
            if (pre == null) list.add(root);
            list.addAll(dfs(root.left, root, true, set));
            list.addAll(dfs(root.right, root, false, set));
        }
        return list;
    }

}