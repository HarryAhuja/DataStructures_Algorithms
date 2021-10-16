/*
 * Node from which two target nodes diverge
 * If one of the target node is ancestor of other, then its the answer
 * 
 * Solution 1: store path from root to p and q
 * Return the last node which is common(after which path diverge)
 * Problem: Needs extra space
 * 
 * Solution 2
 * Return the target node from bottom up approach
 * If a node gets not null value from left and right then that means
 * both nodes are found in left and right. Then return that parent node
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class LCA {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)    return root;
        
        // Traverse left or right even if root has its value
        // Bcs it can be a case that p or q lies in left or right sub tree
        // return root (If one of the target node is ancestor of other, then its lca)
        // or we can skip traversing left or right bcs in each case, root has 
        // to be returned. Value in left or right subtree doesn't matter
        if((root.val == p.val) || (root.val==q.val))    return root;
        
        TreeNode left  = lowestCommonAncestor(root.left,  p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        
        
        if(left!=null && right!=null)   return root;    //root is lca
        else if(left!=null)             return left;    // return found value
        else if(right!=null)            return right;   // return found value
        else                            return null;
    }
    public static void main(String a[])
    {
        
    }
}
