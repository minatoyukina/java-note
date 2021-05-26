package leetcode.summary;

import leetcode._51__100._100.TreeNode;
import org.junit.Test;

import java.util.*;

public class BinaryTree {

    @Test
    public void test() {
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6, new TreeNode(5), new TreeNode(7))
        );
        System.out.println(preOrderR(root));
        System.out.println(preOrderT(root));
        System.out.println(inOrderR(root));
        System.out.println(inOrderT(root));
        System.out.println(postOrderR(root));
        System.out.println(postOrderT(root));
        System.out.println(levelOrderR(root));
        System.out.println(levelOrderT(root));
    }

    //前序遍历
    private List<Integer> preOrderR(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder0(root, list);
        return list;
    }

    private void preOrder0(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preOrder0(root.left, list);
            preOrder0(root.right, list);
        }
    }

    private List<Integer> preOrderT(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return list;
    }

    //中序遍历
    private List<Integer> inOrderR(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder0(root, list);
        return list;
    }

    private void inOrder0(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrder0(root.left, list);
            list.add(root.val);
            inOrder0(root.right, list);
        }
    }

    private List<Integer> inOrderT(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            list.add(pop.val);
            root = pop.right;
        }
        return list;
    }

    //后序遍历
    private List<Integer> postOrderR(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder0(root, list);
        return list;
    }

    private void postOrder0(TreeNode root, List<Integer> list) {
        if (root != null) {
            postOrder0(root.left, list);
            postOrder0(root.right, list);
            list.add(root.val);
        }
    }

    private List<Integer> postOrderT(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> tag = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                tag.push(1);
                root = root.left;
            } else {
                if (tag.peek() == 2) {
                    list.add(stack.pop().val);
                    tag.pop();
                } else {
                    tag.pop();
                    tag.push(2);
                    root = stack.peek().right;
                }
            }
        }
        return list;
    }

    //层序遍历
    private List<List<Integer>> levelOrderR(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrder0(root, 0, list);
        return list;
    }

    private void levelOrder0(TreeNode root, int i, List<List<Integer>> list) {
        if (root != null) {
            List<Integer> level;
            if (i < list.size()) level = list.get(i);
            else {
                level = new ArrayList<>();
                list.add(level);
            }
            level.add(root.val);
            levelOrder0(root.left, i + 1, list);
            levelOrder0(root.right, i + 1, list);
        }
    }

    private List<List<Integer>> levelOrderT(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(level);
        }
        return list;
    }
}
