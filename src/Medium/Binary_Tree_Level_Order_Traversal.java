package Medium;
//Question 102
//Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
//Input: root = [3,9,20,null,null,15,7]
//        Output: [[3],[9,20],[15,7]]

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderHelper(root, 0);
        return result;
    }
    public void levelOrderHelper(TreeNode root, int level){
        if(root == null) return;
        if(result.size() < level + 1)
            result.add(new ArrayList<>());
        result.get(level).add(root.val);
        levelOrderHelper(root.left, level + 1);
        levelOrderHelper(root.right, level + 1);
    }
}
