package leetcode._2051__2100._2096;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(getDirections(Common.arrayToTree(5, 8, 3, 1, null, 4, 7, 6, null, null, null, null, null, null, 2), 4, 3));
        System.out.println(getDirections(Common.arrayToTree(2, 1), 2, 1));
        System.out.println(getDirections(Common.arrayToTree(3, 1, 2), 2, 1));
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        if (root == null) return null;
        StringBuilder a = new StringBuilder(), b = new StringBuilder();
        if (dfs(root, startValue, a) && dfs(root, destValue, b)) {
            int l = 0, r = 0;
            while (l < a.length() && r < b.length() && a.charAt(l) == b.charAt(r)) {
                l++;
                r++;
            }
            return a.substring(l).replace('L', 'U').replace('R', 'U') + b.substring(r);
        }

        String t;
        return (t = getDirections(root.left, startValue, destValue)) == null ? getDirections(root.right, startValue, destValue) : t;
    }

    private boolean dfs(TreeNode node, int val, StringBuilder sb) {
        if (node == null) return false;
        if (node.val == val) return true;
        if (dfs(node.left, val, sb.append("L"))) return true;
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        if (dfs(node.right, val, sb.append("R"))) return true;
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        return false;
    }

}
