/*
 * No need to push all elements in queue/stack in beginning
 * 
 * Only push all left children
 * Push its right whenever call to next is made
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
