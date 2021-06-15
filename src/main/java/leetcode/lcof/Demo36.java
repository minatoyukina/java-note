package leetcode.lcof;

import org.junit.Test;

public class Demo36 {

    @Test
    public void test() {
        System.out.println(treeToDoublyList(new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5))));
    }

    @SuppressWarnings("all")
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node pre;

    private Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        Node head = root, tail = root;
        while (head.left != null) head = head.left;
        while (tail.right != null) tail = tail.right;
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null) pre.right = root;
        Node tmp = pre;
        pre = root;
        pre.left = tmp;
        dfs(root.right);
    }
}
