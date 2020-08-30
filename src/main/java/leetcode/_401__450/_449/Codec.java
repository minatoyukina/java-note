package leetcode._401__450._449;

import leetcode._50__100._100.TreeNode;
import leetcode.util.Common;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    public static void main(String[] args) {
        Codec codec = new Codec();
        Integer[] integers = {4, 3, 5, 1, null, null, 7};
        String serialize = codec.serialize(Common.arrayToTree(integers));
        System.out.println(serialize);
        System.out.println(codec.deserialize(serialize));
    }

    // Encodes a tree to a single string.
    private String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val).append(',');
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else sb.append('x').append(',');
            }
        }
        char[] chars = sb.toString().toCharArray();
        int x = chars.length;
        for (int i = chars.length - 1; i > 0; i = i - 2)
            if (chars[i - 1] == 'x') x = i - 1;
            else break;
        return sb.substring(0, x - 1);
    }

    // Decodes your encoded data to tree.
    private TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        Integer[] arr = new Integer[data.length()];
        String[] split = data.split(",");
        for (int i = 0; i < split.length; i++)
            if (split[i].equals("x")) arr[i] = null;
            else arr[i] = Integer.parseInt(split[i]);
        return Common.arrayToTree(arr);
    }
}
