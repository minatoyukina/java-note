package leetcode._1301__1350._1305;

import leetcode._51__100._100.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(getAllElements(
                new TreeNode(2, new TreeNode(1), new TreeNode(4)),
                new TreeNode(1, new TreeNode(0), new TreeNode(3))
        ));
    }

    private List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        left(s1, root1);
        left(s2, root2);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty() && !s2.isEmpty()) {
                TreeNode t1 = s1.peek(), t2 = s2.peek();
                if (t1.val > t2.val) {
                    list.add(t2.val);
                    left(s2, s2.pop().right);
                } else {
                    list.add(t1.val);
                    left(s1, s1.pop().right);
                }
            } else {
                TreeNode pop = (s1.isEmpty() ? s2 : s1).pop();
                list.add(pop.val);
                left(s1.isEmpty() ? s2 : s1, pop.right);
            }
        }
        return list;
    }

    private void left(Stack<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

}