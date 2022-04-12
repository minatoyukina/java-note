package leetcode._551__600._589;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("all")
public class Demo01 {


    @Test
    public void test() {

    }

    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            list.add(pop.val);
            for (int i = pop.children.size() - 1; i >= 0; i--) stack.push(pop.children.get(i));
        }
        return list;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

}