package data_structure.binarytree;

public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            TreeNode node = invertTree(root.left);
            TreeNode node1 = invertTree(root.right);
            return root;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        TreeNode[] treeNodes=new TreeNode[7];
        treeNodes[0]=new TreeNode(4);
        treeNodes[1]=new TreeNode(2,treeNodes[0].left,null);
        treeNodes[2]=new TreeNode(1,treeNodes[1].left,null);
        treeNodes[3]=new TreeNode(3,null,treeNodes[1].right);
        treeNodes[4]=new TreeNode(7,null,treeNodes[0].right);
        treeNodes[5]=new TreeNode(6,treeNodes[4].left,null);
        treeNodes[6]=new TreeNode(9,null,treeNodes[4].right);
        for (TreeNode treeNode : treeNodes) {
            System.out.println(treeNode.val);
        }
//            invertTree(treeNode);


    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }



    TreeNode(int x,TreeNode left,TreeNode right) {
        val = x;
        this.left= left;
        this.right= right;
    }
}
