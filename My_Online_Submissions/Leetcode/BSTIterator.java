/*
 * No need to push all elements in queue/stack in beginning
 * 
 * Only push all left children
 * Push its right whenever call to next is made
 * 
 * The average time complexity of next() function is O(1) indeed in your case.
 *  As the next function can be called n times at most, and the number of right nodes in 
 *  self.pushAll(tmpNode.right) function is maximal n in a tree which has n nodes, 
 *  so the amortized time complexity is O(1).
 * 
 * suppose we have total 10 nodes in tree
 * in 2 calls of right, I added 5 and 5 nodes in stack
 * 
 * then rest of nodes will have right=null
 * 
 * in worst case next can be called 10 times
 * so avg complexity=O(1)
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Stack;

public class BSTIterator
{
    TreeNode root = new TreeNode();
    Stack<TreeNode> stack= new Stack<TreeNode>();
    
    public void fill_stack(TreeNode root)
    {
        if(root==null)  return;
        
        stack.push(root);
        fill_stack(root.left);
    }
    public BSTIterator(TreeNode root)
    {
        this.root = root;
        
        fill_stack(root);
    }
    
    public int next()
    {
        TreeNode top = stack.pop();
        
        fill_stack(top.right);
        
        return top.val;
    }
    
    public boolean hasNext()
    {
        if(stack.size()>0)  return true;
        else                return false;
    }
}
