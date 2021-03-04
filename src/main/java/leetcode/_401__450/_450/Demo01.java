package leetcode._401__450._450;

import leetcode._50__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(deleteNode(Common.arrayToTree(new Integer[]{5, 3, 6, 2, 4, null, 7}), 7));
        System.out.println(deleteNode(Common.arrayToTree(new Integer[]{2, 1, 3}), 3));
        System.out.println(deleteNode(Common.arrayToTree(new Integer[]{1, null, 2, null, 3, null, 4, null, 5}), 5));
        System.out.println(deleteNode(Common.arrayToTree(new Integer[]{5, 4, null, 3, null, 2, null, 1}), 3));
    }


    private TreeNode parent;

    private TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.right == null && root.val == key) return root.left;
        dfs(root, key);
        return root;
    }

    private void dfs(TreeNode root, int key) {
        if (root != null) {
            int val = root.val;
            if (key < val) {
                parent = root;
                dfs(root.left, key);
            } else if (key > val) {
                parent = root;
                dfs(root.right, key);
            } else {
                TreeNode tmp = root.right;
                if (tmp == null) {
                    if (root == parent.left)
                        parent.left = root.left;
                    if (root == parent.right) {
                        if (root.left != null) parent.right = root.left;
                        else parent.right = null;
                    }
                } else {
                    while (true) {
                        if (tmp.left != null) {
                            if (tmp.left.left == null) {
                                root.val = tmp.left.val;
                                tmp.left = tmp.left.right;
                                break;
                            }
                            tmp = tmp.left;
                        } else {
                            root.val = tmp.val;
                            root.right = tmp.right;
                            break;
                        }
                    }
                }
            }
        }
    }
}
