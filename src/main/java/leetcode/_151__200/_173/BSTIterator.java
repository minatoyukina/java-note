package leetcode._151__200._173;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("all")
public class BSTIterator {

    public static void main(String[] args) {
        BSTIterator iterator = new BSTIterator(Common.arrayToTree(new Integer[]{7, 3, 15, null, null, 9, 20}));
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
    }

    private Iterator<Integer> iterator;

    public BSTIterator(TreeNode root) {
        List list = new ArrayList();
        dfs(root, list);
        iterator = list.iterator();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return iterator.next();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root != null) {
            dfs(root.left, list);
            list.add(root.val);
            dfs(root.right, list);
        }
    }
}
