/*
 *      5
 *   4    6
 *      3   7
 *      
 *  Root 6 is locally true but not globally
 *  So keep track of globally also
 *  
 *  value can be equal to INT.MIN or INT.MAX
 *  So use long to store values out of integer
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class isValidBst {
    public static boolean isValidBSTHelper(TreeNode root,long min,long max) {
        
        if(root == null)    return true;
        
        boolean is_left  = isValidBSTHelper(root.left,min,root.val);
        boolean is_right = isValidBSTHelper(root.right,root.val,max);
        
        if(root.left!=null && root.left.val>=root.val)     return false;
        if(root.right!=null && root.right.val<=root.val)   return false;
        
        if(root.val<=min || root.val>=max)    return false;
        
        return is_left && is_right;
    }
    public static boolean isValidBST(TreeNode root) {
        
        long min = Integer.MIN_VALUE;
        long max = Integer.MAX_VALUE;
        min-=1;
        max+=1;
        
        return isValidBSTHelper(root,min,max);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        isValidBST(new TreeNode(10));
    }

}
