/*
 *              8
 *        4             12
 *   2        6       10   14
 * 
 *   key =3, ceil=4
 *   3 lies on the left of 4 but of left of 4 is <3
 *   so all elements of subtree with root=2 will be less than 3
 *   so 3 is the correct place
 *   ceil = 4
 *   
 *   same with key=5 but on right side
 *   
 *   key=0 and 1 should lie on left of 2 but left of 2 is null, so 2 is ans
 *   
 *   key = 7
 *   right of 6 is null-> that means ceil of 7 is the ancestor which is not
 *   traversed yet in inorder(whos left contains <=6)-> 8
 *   
 *   when value<root and root.left==null-> that means root is ans
 *   when value>root and root.right==null-> that means deepest ancestor which is not traversed
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class FloorCeilBst {

    public static int ceil_helper(TreeNode root, int key,int anc)
    {
        if(root==null)      return -1;
        
        if(root.val==key)   return key;
        
        if(key<root.val)
        {
            int left_ans = ceil_helper(root.left,key,root.val);
            
            if(left_ans==-1)    return root.val;
            else                return left_ans;
            
        }
        else
        {
            int right_ans = ceil_helper(root.right,key,anc);
            
            if(right_ans == -1) return anc;
            else                return right_ans;
        }
    }
    public static int ceil(TreeNode root, int i)
    {
        return ceil_helper(root,i,-1);
    }
    
    public static int floor_helper(TreeNode root, int key,int anc)
    {
        if(root==null)      return -1;
        
        if(root.val==key)   return key;
        
        if(key<root.val)
        {
            int left_ans = floor_helper(root.left,key,anc);
            
            if(left_ans==-1)    return anc;
            else                return left_ans;
            
        }
        else
        {
            int right_ans = floor_helper(root.right,key,root.val);
            
            if(right_ans == -1) return root.val;
            else                return right_ans;
        }
    }
    public static int floor(TreeNode root, int i)
    {
        return floor_helper(root,i,-1);
    }
    public static void main(String[] args) {
        TreeNode root   = new TreeNode(8);
        root.left        = new TreeNode(4); 
        root.right       = new TreeNode(12);
        root.left.left   = new TreeNode(2);
        root.left.right  = new TreeNode(6);
        root.right.left  = new TreeNode(10);
        root.right.right = new TreeNode(14);
        
        for (int i = 0; i < 16; i++)
        {
            System.out.println("Ceil of i "+i+" is "+ceil(root,i));
        }
        
        for (int i = 0; i < 16; i++)
        {
            System.out.println("floor of i "+i+" is "+floor(root,i));
        }
        
    }

}
