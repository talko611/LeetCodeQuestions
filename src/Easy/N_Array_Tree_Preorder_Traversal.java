package Easy;

//Question 589
//Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
//Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

//Input: root = [1,null,3,2,4,null,5,6]
//Output: [1,3,5,6,2,4]


import Utils.Node;

import java.util.ArrayList;
import java.util.List;

public class N_Array_Tree_Preorder_Traversal {
    List<Integer> preOrderTree = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) return preOrderTree;
        preOrderTree.add(root.val);
        for(Node child : root.children){
            preorder(child);
        }
        return preOrderTree;
    }
}
