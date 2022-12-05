package Utils;

import java.util.List;

public class TreeNode {
 public int val;
 public TreeNode right;
 public TreeNode left;

 public TreeNode(){}

 public TreeNode(int val, TreeNode right, TreeNode left) {
  this.val = val;
  this.right = right;
  this.left = left;
 }

 public TreeNode(int val) {
  this.val = val;
 }

 public static TreeNode insertLevelOrder(int[] arr, int i)
 {
  TreeNode root = null;
  // Base case for recursion
  if (i < arr.length && arr[i] != -200) {
   root = new TreeNode(arr[i]);

   // insert left child
   root.left = insertLevelOrder(arr, 2 * i + 1);
   // insert right child
   root.right = insertLevelOrder(arr, 2 * i + 2);
  }
  return root;
 }
}
