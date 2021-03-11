package leetcode._401__450._437;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(pathSum(Common.arrayToTree(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), 8));
        System.out.println(pathSum(Common.arrayToTree(1, 2), 2));
    }

    private int count = 0;

    private int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        dfs(root, list, sum);
        return count;
    }

    private void dfs(TreeNode root, List<Integer> list, int target) {
        if (root == null) return;
        if (root.val == target) count++;
        if (root.left != null) {
            List<Integer> copy = new ArrayList<>();
            copy.add(root.left.val);
            for (Integer integer : list) {
                int i = integer + root.left.val;
                if (target == i) count++;
                copy.add(i);
            }
            dfs(root.left, copy, target);
        }
        if (root.right != null) {
            List<Integer> copy = new ArrayList<>();
            copy.add(root.right.val);
            for (Integer integer : list) {
                int i = integer + root.right.val;
                if (target == i) count++;
                copy.add(i);
            }
            dfs(root.right, copy, target);
        }
    }

}