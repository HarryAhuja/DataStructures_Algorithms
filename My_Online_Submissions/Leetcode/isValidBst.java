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
 *  
 *  Keeping only two variables max and min will confuse
 *  since we can't differentiate max of left subfree
 *  and max of right subtree.
 *  They needs to be separated
 *  
 *  Above approach will also not work since
 *  global variables can't differentiate between
 *  max of left(4*,5) or max of left subtree(3*,6,7)
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

class MIN_MAX
{
    long min;
    long max;
    boolean is_bst;
}

public class isValidBst {
    public static long max(long a,long b)
    {
        return a>b?a:b;
    }
    public static long min(long a,long b)
    {
        return a<b?a:b;
    }
    
    public static MIN_MAX isValidBSTHelper(TreeNode root,MIN_MAX m) {
        
        MIN_MAX left,right;
        MIN_MAX ans =new MIN_MAX();
        ans.is_bst = m.is_bst;
        ans.max    = m.max;
        ans.min    = m.min;
        
        if(root == null)    return m;
        
        left = isValidBSTHelper(root.left,m);
        right= isValidBSTHelper(root.right,m);
        
        if(root.val<=left.max || root.val>=right.min)
        {
            ans.is_bst = false;
            return ans;
        }
        
        ans.max = max(right.max,root.val);
        ans.min = min(left.min,root.val);
        
        ans.is_bst = left.is_bst && right.is_bst;
        return ans;
    }
    public static boolean isValidBST(TreeNode root) {
        
        MIN_MAX m = new MIN_MAX();
        m.min = Integer.MAX_VALUE;
        m.max = Integer.MIN_VALUE;
        m.min+=1;
        m.max-=1;
        m.is_bst = true;
        
        MIN_MAX res = isValidBSTHelper(root,m);
        return res.is_bst;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }

}
