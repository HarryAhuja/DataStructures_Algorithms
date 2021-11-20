/*
 * if right subftree is null then these cases
 * 
 * if target node is in left sbt, then it means parent is not visited
 * in inorder. Then parent is ans as it will be visited next
 * 
 * if target node is in right sbt, then it means parent is already visited
 * in inorder. Then parent is not ans.
 * We need to go the parent which is unvisited. That parent of the child
 * which is the left subftree call
 * Go to nearest ancestor for which target is in its left subftree
 * 
 * Problem: How do we got to parent: use parent pointer
 * or start from root
 * 
 * Ans would be deepest ancestor(start from root) or first(starting from target)
 * for which target is in left subtree. That is why we always update succ while
 * going left not just one time
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class InorderSuccessorBST {

    public static int find_min(TreeNode root)
    {
        if(root.left == null) return root.val;
        
        return find_min(root.left);
    }
    public static int find_ancestor(TreeNode root,TreeNode target,int anc)
    {
        if(root == null)    return -1;
        
        if(target.val>root.val) return find_ancestor(root.right, target,anc);
        if(target.val<root.val) return find_ancestor(root.left, target,root.val);
        
        return anc;
    }
    public static int inoder_successor(TreeNode root,TreeNode target)
    {
        if(root == null)    return -1;
        
        if(target.right!=null)  return find_min(target.right);
        
        return find_ancestor(root,target,-1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        
        System.out.println(inoder_successor(root,root.left.right.left));
    }

}
