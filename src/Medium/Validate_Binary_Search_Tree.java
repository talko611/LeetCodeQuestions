package Medium;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

// Question 98
//Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//
//        A valid BST is defined as follows:
//        The left subtree of a node contains only nodes with keys less than the node's key.
//        The right subtree of a node contains only nodes with keys greater than the node's key.
//        Both the left and right subtrees must also be binary search trees.
public class Validate_Binary_Search_Tree {
    public List<Integer> preOrderTree = new ArrayList<>();
    public boolean isValidBST(TreeNode root){
        setPreOrderTreeList(root);
        for(int i = 1; i < preOrderTree.size(); ++i){
            if(preOrderTree.get(i -1) >= preOrderTree.get(i)){
                return false;
            }
        }
        return true;
    }

    public void setPreOrderTreeList(TreeNode root){
        if(root == null){
            return;
        }
        setPreOrderTreeList(root.left);
        preOrderTree.add(root.val);
        setPreOrderTreeList(root.right);
    }

    public static void main(String[] args) {
        Validate_Binary_Search_Tree solution = new Validate_Binary_Search_Tree();
        TreeNode node = new TreeNode(5, new TreeNode(7, new TreeNode(8), new TreeNode(6)), new TreeNode(1));
        System.out.println(solution.isValidBST(node));
    }
}
