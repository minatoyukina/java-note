package leetcode.lcci;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0408 {

    @Test
    public void test() {
        TreeNode r = new TreeNode(3);
        TreeNode p = Common.arrayToTree(5, 6, 2, null, null, 7, 4);
        TreeNode q = Common.arrayToTree(1, 0, 8);
        r.left = p;
        r.right = q;
        System.out.println(lowestCommonAncestor(r, p, q));
    }

    private TreeNode ans;

    private Map<TreeNode, Map<TreeNode, Boolean>> map = new HashMap<>();

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;
        if (contains(root, p) && contains(root, q)) ans = root;
        dfs(root.left, p, q);
        dfs(root.right, p, q);
    }

    private boolean contains(TreeNode root, TreeNode p) {
        if (root == null) return false;
        Boolean exist = map.getOrDefault(root, new HashMap<>()).getOrDefault(p, null);
        if (exist != null) return exist;
        if (root == p) return true;
        boolean b = contains(root.left, p) || contains(root.right, p);
        Map<TreeNode, Boolean> sub = map.getOrDefault(root, new HashMap<>());
        sub.put(p, b);
        map.put(root, sub);
        return b;
    }

}
