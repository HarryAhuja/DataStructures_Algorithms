package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class BalancedBT
{
    public boolean is_height_balanced = true;
    
    public int isBalancedHelper(TreeNode root)
    {
        if(root==null)  return 0;
        
        int left   = isBalancedHelper(root.left);
        int right  = isBalancedHelper(root.right);
        
        if(Math.abs(left-right)>1)
        {
            is_height_balanced = false;
        }
        
        return 1+Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root)
    {
        // empty tree is height balanced
        if(root==null)  return true;
        
        isBalancedHelper(root);
        
        return is_height_balanced;
        
    }
}
