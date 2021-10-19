package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

class RightNode {
    public int val;
    public RightNode left;
    public RightNode right;
    public RightNode next;

    public RightNode() {}
    
    public RightNode(int _val)
    {
        val = _val;
    }

    public RightNode(int _val, RightNode _left, RightNode _right, RightNode _next)
    {
        val   = _val;
        left  = _left;
        right = _right;
        next  = _next;
    }
};

public class PopulatingNextRightPointers {
    
    public static RightNode connect(RightNode root)
    {
       if(root == null) return root;
       
       Queue<RightNode> queue = new ArrayDeque<>();
       queue.offer(root);
       
       while(queue.isEmpty()==false)
       {
           int       size = queue.size();
           RightNode prev = null;
           
           for(int i=0;i<size;i++)
           {
               RightNode front = queue.poll();
               front.next      = prev;
               prev            = front;
               
               if(front.right != null)   queue.offer(front.right);
               if(front.left  != null)   queue.offer(front.left);

           }
       }

       return root;
    }
    
    public static void main(String a[])
    {
        RightNode root   = new RightNode(3);
        root.left        = new RightNode(9); 
        root.right       = new RightNode(20);
        root.left.left   = new RightNode(11);
        root.left.right  = new RightNode(10);
        root.right.left  = new RightNode(15);
        root.right.right = new RightNode(7);
        
        connect(root);
    }
}
