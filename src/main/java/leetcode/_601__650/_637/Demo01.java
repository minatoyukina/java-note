package leetcode._601__650._637;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(averageOfLevels(Common.arrayToTree(3, 9, 20, null, null, 15, 7)));
    }


    private List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size(), n = size;
            double sum = 0;
            while (n-- > 0) {
                TreeNode poll = queue.poll();
                if (poll == null) break;
                sum += poll.val;
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            list.add(sum / size);
        }
        return list;
    }
}