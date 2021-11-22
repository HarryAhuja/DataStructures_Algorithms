package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class FlattenBtToLinkedList
{
    static TreeNode tail = null;
    static TreeNode new_root;
    
    public static TreeNode flatten_helper(TreeNode root)
    {
        if(root==null)  return null;
        
        if(tail==null)
        {
            tail = new TreeNode(root.val);
            new_root = tail;
        }
        else
        {
            tail = new TreeNode(root.val);
        }
        
        
    }
    public static void flatten(TreeNode root)
    {
        if(root==null)
        {
            root=null;
            return;
        }
        
        flatten_helper(root);
        
        root = new_root;
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
