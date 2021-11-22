/*
 * Below dfs solution works bcs we visit in pre-order sequence
 * We will add new list whenever we encounter very first node in a level
 * bcs we are visiting left before right(level order), that means if left
 * is null also, then we add new list at right bcs right is first node at
 * that level
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.LinkedList;
import java.util.List;


public class LevelOrderTraversal {
    public static void level_order_helper(TreeNode root,List<List<Integer>> l, int height)
    {
        if(root == null)    return;
        
        if(height==l.size())
        {
            l.add(new LinkedList<Integer>());
        }
        
        l.get(height).add(root.val);
        
        level_order_helper(root.left,l,height+1);
        level_order_helper(root.right,l,height+1);
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> l = new LinkedList<List<Integer>>();
        
        level_order_helper(root,l,0);
        
        return l;
    }
    public static void main(String arg[])
    {
        TreeNode root         = new TreeNode(3);
        root.left             = new TreeNode(9);
        root.right            = new TreeNode(10);
        root.right.left       = new TreeNode(15);
        root.right.right      = new TreeNode(7);
        List<List<Integer>> l = levelOrder(root);
    }
}
