package leetcode._851__900._889;

import leetcode._51__100._100.TreeNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1}));
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return dfs(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }


    private TreeNode dfs(int[] preorder, int[] postorder, int il, int ir, int pl, int pr) {
        if (il > ir) return null;
        TreeNode node = new TreeNode(preorder[il]);
        if (il == ir) return node;
        Set<Integer> set = new HashSet<>();
        int mi = 0, mp = 0;
        for (int i = pl; i <= pr - 1; i++) {
            set.add(postorder[i]);
            mp = i;
            if (postorder[i] == preorder[il + 1]) break;
        }
        for (int i = il + 1; i <= ir; i++) {
            if (set.contains(preorder[i])) mi = i;
            else break;
        }
        node.left = dfs(preorder, postorder, il + 1, mi, pl, mp);
        node.right = dfs(preorder, postorder, mi + 1, ir, mp + 1, pr - 1);
        return node;
    }

}