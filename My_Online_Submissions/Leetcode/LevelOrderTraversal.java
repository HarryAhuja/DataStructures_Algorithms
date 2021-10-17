/*
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrderTraversal {
    public void level_order_helper(TreeNode root,List<List<Integer>> l)
    {
        if(root == null)    return;
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        
        queue.offer(root);
        
        while(queue.isEmpty()==false)
        {
            int level_num = queue.size();
            List<Integer> sub_list = new LinkedList<>();
            
            for(int i=1;i<=level_num;i++)
            {
                TreeNode front = queue.poll();
                sub_list.add(front.val);
                
                // ArrayDeque doesn't allow null
                if(front.left!=null)     queue.offer(front.left);
                if(front.right!=null)    queue.offer(front.right);
            }
            
            l.add(sub_list);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> l = new LinkedList<List<Integer>>();
        
        level_order_helper(root,l);
        
        return l;
    }
}
