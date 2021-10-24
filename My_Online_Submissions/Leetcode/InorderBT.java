/*
 * Think on similar lines of recursion
 * 
 *  if(root==null)
 *  left
 *  print
 *  right
 *  
 *  Once left becomes null, we pop root, print it and call right
 * 
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderBT {
    public static void inorderTraversalHelper(TreeNode root,List<Integer> l) {
        if(root==null)  return;
        
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode node = root;
       
        while(true)
        {
            if(node!=null)
            {
                stack.push(node);
                node = node.left;
            }
            else
            {
                // Before pop
                if(stack.isEmpty()==true)   break;
                
                node = stack.pop();
                System.out.println(node.val+" ");
                
                node = node.right;
            }
        }
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> l = new ArrayList<Integer>();
        inorderTraversalHelper(root,l);
        
        return l;
    }
    public static void main(String[] args) {
        
        List<Integer> l = inorderTraversal(new TreeNode(10));
    }

}
