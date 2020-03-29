package leetcode.util;

import leetcode._100.TreeNode;

import java.util.List;

public class Common {

    public static TreeNode listToTreeNode(List<Integer> list) {
        TreeNode node = null;
        for (Integer integer : list) {
            if (node == null) {
                node = new TreeNode(integer);
                continue;
            }
            node.left = new TreeNode(integer);
        }
        return node;
    }
}
