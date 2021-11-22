/*
 *  Similar to vertical order leetcode
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class TopViewNode
{
    TreeNode node;
    int hor_distance;
    
    public TopViewNode()
    {
        node = null;
        hor_distance = 0;
    }
    
    public TopViewNode(TreeNode v,int h)
    {
        node = v;
        hor_distance = h;
    }
}
public class TopViewBT
{
    public void TopView(TreeNode root)
    {
        Queue<TopViewNode>    q = new ArrayDeque<TopViewNode>();
        Map<Integer,Integer> map = new HashMap<>();
        
        q.offer(new TopViewNode(root,0));
        
        while(q.isEmpty()==false)
        {
            TopViewNode front = q.poll();
            
            if(map.containsKey(front.hor_distance)==false)
            {
                map.put(front.hor_distance, front.node.val);
                System.out.println(front.node.val+" ");
            }
            
            if(front.node.left!=null)
                q.offer(new TopViewNode(front.node.left,front.hor_distance-1));
            if(front.node.right!=null)
                q.offer(new TopViewNode(front.node.left,front.hor_distance+1));
        }

    }
}
