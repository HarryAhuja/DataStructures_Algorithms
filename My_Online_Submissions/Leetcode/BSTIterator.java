package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BSTIterator
{
    TreeNode root = new TreeNode();
    Queue<TreeNode> queue= new ArrayDeque<TreeNode>();
    
    public void fill_queue(TreeNode root)
    {
        if(root==null)  return;
        
        fill_queue(root.left);
        queue.offer(root);
        fill_queue(root.right);
    }
    public BSTIterator(TreeNode root)
    {
        this.root = root;
        
        fill_queue(root);
    }
    
    public int next()
    {
        return queue.poll().val;
    }
    
    public boolean hasNext()
    {
        if(queue.size()>0)  return true;
        else                return false;
    }
}
