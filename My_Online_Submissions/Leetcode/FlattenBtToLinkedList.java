package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class FlattenBtToLinkedList
{
    static TreeNode prev_node_done = null;
    public static void flatten(TreeNode root)
    {
       if(root==null)   return;
       
       flatten(root.right);
       flatten(root.left);
       
       root.right = prev_node_done;
       root.left  = null;
       
       prev_node_done = root;
       
    }
    
    public static void main(String arg[])
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        
        flatten(root);
    }
}
