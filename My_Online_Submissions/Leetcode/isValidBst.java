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
 *  
 *  In bottom up approach, always deep copy local variables
 *  otherwise pointer kind of thing will happen
 *  Don't --> ans = m
 *  Do    ->  ans.is_bst = m.is_bst
 *  
 *  (long)m.min = Integer.MAX_VALUE+1L -> correct
 *  (long)m.min = Integer.MAX_VALUE+1 -> incorrect(wrap around)
 *  
 *  To store in long, atleast one operand on right side should be long
 *  
 *  When arithmetic is performed on integers, the result will always be an integer.
 *  You can assign that result to a long, double, or float with automatic type conversion,
 *  but having started as an int or long, the result will likely not be what you expect.
 *  For instance, if the result of int division is assigned to a floating-point variable,
 *  precision will have been lost before the assignment. Likewise, if the result of 
 *  multiplication is assigned to a long, it may have already overflowed before the assignment.
 *  In either case, the result will not be what was expected. Instead, at least one operand 
 *  should be cast or promoted to the final type before the operation takes place.
 *  
 *  
 *  1st submission
 *  passing to right only changes the max value.
 *  Min value seen so far is retained as it is so that any node in any subtree
 *  in right of root(original root) should be greater than min value so far
 *  
 *  Same with left
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
        
        /*
         * There are can diff max,min from left and right but we are only
         * concerned for max from left and min from right
         *  
         * max from left  = 7
         * min from right = 3
         *           (0,7) 4  (3,6)
         *       1                 5
         *  0       7         3          6
         * 
         */
        if(root.val<=left.max || root.val>=right.min)
        {
            ans.is_bst = false;
            return ans;
        }
        
        // if this line hits that means all values in left of root are lesser and 
        // right values are greater
        // Therefore max is taken from right and min is taken from left to
        // track max and min seen so far
        ans.max = max(right.max,root.val);
        ans.min = min(left.min,root.val);
        
        ans.is_bst = left.is_bst && right.is_bst;
        return ans;
    }
    public static boolean isValidBST(TreeNode root) {
        
        MIN_MAX m = new MIN_MAX();
        m.min = Integer.MAX_VALUE+1L;   // autounboxing from Integer to long is not possible
        m.max = Integer.MIN_VALUE-1L;   // Convert first Integer to Long then into long
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
