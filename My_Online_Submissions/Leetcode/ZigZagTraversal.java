/*
 * Call always from left to right
 * but add at last or at first(instead of reversing list)
 * depending upon the level
 * 
 * How to ping pong
 * 1.) i = i+1 always and i%2, even or odd
 * 2.) i^1 -> 0/1 pair
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTraversal {

    static final int LR = 0;
    static final int RL = 1;
    
    public static void zigzagLevelOrderHelper(TreeNode root,List<List<Integer>> l, int height,
                                              final int dir)
    {
        if(root == null)    return;
        
        if(height>=l.size())
        {
            l.add(new LinkedList<Integer>());
        }

        if(dir == LR)   l.get(height).add(root.val);
        else            l.get(height).add(0,root.val);
        
        zigzagLevelOrderHelper(root.left,l,height+1,dir^1);
        zigzagLevelOrderHelper(root.right,l,height+1,dir^1);
        
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        //ArrayList to add at last or first
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        
        zigzagLevelOrderHelper(root,l,0,LR);
        
        return l;
    }
    public static void main(String arg[])
    {
        TreeNode root         = new TreeNode(3);
        root.left             = new TreeNode(9);
        root.right            = new TreeNode(20);
        root.right.left       = new TreeNode(15);
        root.right.right      = new TreeNode(7);
        List<List<Integer>> l = zigzagLevelOrder(root);
        System.out.println(l);
    }

}
