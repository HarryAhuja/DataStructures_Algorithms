/*
 *          2
 *       -1
 *       
 * Acc to question, 2 can only be ans since its a path(doubt)
 * if left = negative-> don't include it, will reduce the sum
 * same for right
 * if both are negative, take root only
 * if both are positive, take max of(left,right)+root
 * 
 * max(0,left)-> ignores negative cases
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class MaxPathSumBT {

    // there can be negative numbers also
    private int maximum =  Integer.MIN_VALUE;
     
    public int maxPathSumHelper(TreeNode root)
    {
        if(root==null)  return 0;
        
        int left  = Math.max(0,maxPathSumHelper(root.left));
        int right = Math.max(0,maxPathSumHelper(root.right));
        
        maximum = Math.max(maximum,left+right+root.val);
        
        return root.val+Math.max(left,right);
    }
    
    public int maxPathSum(TreeNode root)
    {
        if(root==null)  return 0;
        
        maxPathSumHelper(root);
        
        return maximum;
    }
    public static void main(String[] args)
    {
        
        

    }

}
