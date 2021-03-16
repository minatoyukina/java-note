package leetcode._101__150._105;

import leetcode._51__100._100.TreeNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(buildTree(new int[]{5, 4, 2, 1, 3}, new int[]{1, 2, 3, 4, 5}));
        System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        return dfs(inorder, preorder, 0, preorder.length - 1, 0);
    }

    private TreeNode dfs(int[] inorder, int[] preorder, int left, int right, int pIndex) {
        if (left > right) return null;
        int pVal = preorder[pIndex];
        TreeNode root = new TreeNode(pVal);
        if (left == right) return root;
        int iIndex = index(inorder, pVal);
        Set<Integer> set = new HashSet<>();
        for (int i = left; i < iIndex; i++) {
            set.add(inorder[i]);
        }
        int rightPIndex = -1;
        for (int i = pIndex + 1; i < preorder.length; i++) {
            if (set.isEmpty()) {
                rightPIndex = pIndex + 1;
                break;
            }
            if (!set.contains(preorder[i])) {
                rightPIndex = i;
                break;
            }
        }
        TreeNode l = set.isEmpty() ? null : dfs(inorder, preorder, left, iIndex - 1, pIndex + 1);
        TreeNode r = rightPIndex < 0 ? null : dfs(inorder, preorder, iIndex + 1, right, rightPIndex);
        root.left = l;
        root.right = r;
        return root;
    }

    private int index(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

}