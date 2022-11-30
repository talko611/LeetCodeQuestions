package Easy;
//Question 543

//Given the root of a binary tree, return the length of the diameter of the tree.
//The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//The length of a path between two nodes is represented by the number of edges between them.


import Utils.TreeNode;

public class Diameter_of_Binary_Tree {
    private static class Data{
        int maxLength;
        int maxDiameter;

        public Data(int maxLength, int maxDiameter) {
            this.maxLength = maxLength;
            this.maxDiameter = maxDiameter;
        }

        public int getMaxLength() {
            return maxLength;
        }

        public int getMaxDiameter() {
            return maxDiameter;
        }

        public void setMaxLength(int maxLength) {
            this.maxLength = maxLength;
        }

        public void setMaxDiameter(int maxDiameter) {
            this.maxDiameter = maxDiameter;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).maxDiameter;
    }
    public Data helper ( TreeNode root){
        if(root == null) return new Data(0, 0);
        Data left = helper(root.left);
        Data right = helper(root.right);
        int maxDiameter = left.maxLength + right.maxLength;
        return new Data(Math.max(right.maxLength, left.maxLength) + 1, Math.max(maxDiameter, Math.max(left.maxDiameter, right.maxDiameter)));
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        TreeNode root = new TreeNode(1,new TreeNode(2), null);
        Diameter_of_Binary_Tree solution  = new Diameter_of_Binary_Tree();
        System.out.println(solution.diameterOfBinaryTree(root));
    }
}
