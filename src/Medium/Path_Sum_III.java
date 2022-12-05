package Medium;
//Question 437
//Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
//The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).


import Utils.TreeNode;

import java.util.ArrayList;

public class Path_Sum_III {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return  0;
        if(targetSum - root.val == 0) return 1;
        int subtract = targetSum - root.val < 0  ? 0 : root.val;
        return pathSum(root.right, targetSum - subtract) + pathSum(root.left, targetSum - subtract);
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.insertLevelOrder(new int[]{5,4,8,11, -200,13,4,7,2, -200, -200,5,1},22);
        Path_Sum_III solution = new Path_Sum_III();
        System.out.println(solution.pathSum(node, 22));
    }
}



//[5,4,8,11,null,13,4,7,2,null,null,5,1]