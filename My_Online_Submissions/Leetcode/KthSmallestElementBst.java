package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

 class TreeNode
 {
     int val;
     TreeNode left;
     TreeNode right;
     
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right)
     {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

public class KthSmallestElementBst
{
    static int index = 0;
    static int ans   = -1;
    
    public static void kth_smallest_helper(TreeNode root, int k)
    {
        if(root == null)    return;
        
        kth_smallest_helper(root.left, k);
        
        index++;
        if(index == k)
        {
            ans = root.val;
            return;
        }
        
        kth_smallest_helper(root.right, k);
    }
    public static int kthSmallest(TreeNode root, int k)
    {
        if(root == null)    return -1;
        
        kth_smallest_helper(root,k);
        
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = null;
        
        root           = new TreeNode(3,null,null);
        root.left      = new TreeNode(1,null,null);
        root.right     = new TreeNode(4,null,null);
        root.left.right = new TreeNode(2,null,null);
        
        System.out.println(kthSmallest(root,1));

    }

}
