package Easy;

import Utils.TreeNode;

import java.util.AbstractMap;
import java.util.Map;

public class Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return helper(root).getKey();
    }

    private Map.Entry<Boolean, Integer> helper(TreeNode root){
        if(root == null) return new AbstractMap.SimpleEntry<>(true, 0);
        Map.Entry<Boolean,Integer> left = helper(root.left);
        Map.Entry<Boolean,Integer> right = helper(root.right);
        return new AbstractMap.SimpleEntry<>(left.getKey() && right.getKey() && Math.abs(left.getValue() - right.getValue()) <=1, Math.max(left.getValue(), right.getValue()) + 1);
    }
    //Simple solution
    private int isBalancedHelper(TreeNode root){
        if(root == null) return 0;
        int left = isBalancedHelper(root.left);
        int right = isBalancedHelper(root.right);
        if(left == -1 || right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
        TreeNode tree2 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Balanced_Binary_Tree solution  = new Balanced_Binary_Tree();
        System.out.println(solution.isBalanced(tree));
        System.out.println(solution.isBalanced(tree2));
    }
}
