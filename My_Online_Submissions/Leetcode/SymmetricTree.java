/*
 * == operator usage for null comparison
 * Use left!=null && right!=null for explicit comparison
 * instread of right==left
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class SymmetricTree {
    
    public boolean isSymmetricHelper(TreeNode left,TreeNode right)
    {
        if(left!=null && right!=null)
        {
            if(left.val!=right.val) return false;
            
            boolean left_sym = isSymmetricHelper(left.left, right.right);
            boolean right_sym = isSymmetricHelper(left.right, right.left);
            
            return left_sym && right_sym;
        }
        else if(left == right)  return true;
        else                    return false;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)    return true;
        
        return isSymmetricHelper(root.left,root.right);
    }

}
