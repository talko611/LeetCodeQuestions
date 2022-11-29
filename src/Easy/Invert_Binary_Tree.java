package Easy;

//Question 226

import Utils.TreeNode;

//Given the root of a binary tree, invert the tree, and return its root.
public class Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
