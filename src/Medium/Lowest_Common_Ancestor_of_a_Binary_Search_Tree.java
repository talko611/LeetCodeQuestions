package Medium;
//Question 235

//Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
//        According to the definition of LCA on Wikipedia:
//        “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

import Utils.TreeNode;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p ,q);
        return root;
    }

    public static void main(String[] args) {
        Lowest_Common_Ancestor_of_a_Binary_Search_Tree solution = new Lowest_Common_Ancestor_of_a_Binary_Search_Tree();
        TreeNode node = new TreeNode(6, new TreeNode(8, new TreeNode(8), new TreeNode(7)), new TreeNode(2, new TreeNode(4, new TreeNode(5),new TreeNode(3)), new TreeNode(0)));
        System.out.println(solution.lowestCommonAncestor(node, new TreeNode(3), new TreeNode(5)).val);
    }
}
