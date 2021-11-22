package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class RightSideViewBT
{
    public static int max_level = 0;
    public static void right_side_view_helper(TreeNode root,List<Integer> l,int level)
    {
        if(root==null)  return;
        
        if(max_level<level)
        {
            max_level = level;
            l.add(root.val);
        }
        
        right_side_view_helper(root.right,l,level+1);
        right_side_view_helper(root.left,l,level+1);
        
    }
    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> l = new ArrayList<Integer>();

        right_side_view_helper(root,l,1);
        
        return l;
    }
}
