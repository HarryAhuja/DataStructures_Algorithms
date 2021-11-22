/*
 * The idea is to keep track of the maximum level also. 
 * Whenever we see a node whose level is more than maximum level so far, we print the
 *  node because this is the first node in its level
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeftSideViewBT
{
    public static int max_level = 0;
    public static void left_side_view_helper(TreeNode root,List<Integer> l,int level)
    {
        if(root==null)  return;
        
        if(max_level<level)
        {
            max_level = level;
            l.add(root.val);
        }
        
        left_side_view_helper(root.left,l,level+1);
        left_side_view_helper(root.right,l,level+1);
    }
    public static List<Integer> leftSideView(TreeNode root)
    {
        List<Integer> l = new ArrayList<Integer>();

        left_side_view_helper(root,l,1);
        
        return l;
    }
    
    public static void main(String a[])
    {
        TreeNode root = new TreeNode(4);
        root.left     = new TreeNode(5);
        root.right    = new TreeNode(2);
        root.right.left= new TreeNode(3);
        root.right.right    = new TreeNode(1);
        root.right.left.left= new TreeNode(6);
        root.right.left.right= new TreeNode(7);
        
        System.out.println(leftSideView(root));
    }
    
}
