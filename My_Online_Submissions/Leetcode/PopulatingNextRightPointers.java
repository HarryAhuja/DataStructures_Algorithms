/*
 * This solution works because we are doing pre-order
 * We are connecting root->next to its required node before moving
 * to left and right
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;


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
    
    public static RightNode connect_helper(RightNode root,RightNode next)
    {
       if(root == null) return null;
       
       root.next = next;                     //preorder
       
       // Next would always be right of same root
       connect_helper(root.left,root.right); 
       // Next of right will either null(in case its last node of level)
       // or root.next.left bcs left will never be null(complete tree)
       // If not a complete tree, then we have to think
       // Then can't connect to null for in between node of level
       connect_helper(root.right,(root.next==null?null:root.next.left));
       
       return root;
       
    }
    
    public static RightNode connect(RightNode root)
    {
       return connect_helper(root,null);
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
