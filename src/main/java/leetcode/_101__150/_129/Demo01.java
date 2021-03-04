package leetcode._101__150._129;

import leetcode._50__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(sumNumbers(Common.arrayToTree(1, 2, 3)));
        System.out.println(sumNumbers(Common.arrayToTree(4, 9, 0, 5, 1)));
        System.out.println(sumNumbers(Common.arrayToTree(9)));
    }

    private int sumNumbers(TreeNode root) {
        List<String> list = new ArrayList<>();
        Map<TreeNode, String> map = new HashMap<>();
        String s = String.valueOf(root.val);
        map.put(root, s);
        if (root.left == null && root.right == null) list.add(s);
        dfs(root, map, list);
        return Math.toIntExact(list.stream().map(Long::parseLong).reduce(Long::sum).orElse(0L));
    }

    private void dfs(TreeNode root, Map<TreeNode, String> map, List<String> list) {
        if (root != null) {
            String s = map.get(root);
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left != null) {
                map.put(left, s + left.val);
                if (left.left == null && left.right == null) {
                    list.add(s + left.val);
                }
            }
            if (right != null) {
                map.put(right, s + right.val);
                if (right.left == null && right.right == null) {
                    list.add(s + right.val);
                }
            }
            dfs(root.left, map, list);
            dfs(root.right, map, list);
        }
    }
}
