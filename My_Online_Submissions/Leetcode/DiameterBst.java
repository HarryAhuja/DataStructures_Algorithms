/*
 * although the longest path doesn't have to go through the root node, 
 * it has to pass the root node of some subtree of the tree (because it has to be 
 * from one leaf node to another leaf node, otherwise we can extend it for free). 
 * The longest path that passes a given node as the ROOT node is T = left_height+right_height. 
 * So you just calculate T for all nodes and output the max T.
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class DiameterBst {

    static int max_value = Integer.MIN_VALUE;
    
    static int max(int a,int b)
    {
        return a>b?a:b;
    }
    
    public static int diameterOfBinaryTreeHelper(TreeNode root) {
        
        if(root == null)    return 0;
        
        int height_left  = diameterOfBinaryTreeHelper(root.left);
        int height_right = diameterOfBinaryTreeHelper(root.right);
        
        max_value = max(max_value,height_left+height_right);
        
        return 1+max(height_left,height_right);     // Return height of the tree
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        
        diameterOfBinaryTreeHelper(root);
        return max_value;
    }
    public static void main(String[] args) {
        TreeNode root   = new TreeNode(1);
        root.left       = new TreeNode(2);
        root.right      = new TreeNode(3);
        root.left.left  = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }

}
