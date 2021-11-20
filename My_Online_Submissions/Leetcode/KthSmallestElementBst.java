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
    // in online platform, dont make it static
    // it will not get reset on multiple tc
    public static int index = 0;
    
    
    public static int kthSmallest(TreeNode root, int k)
    {
        if(root == null)    return -1;
        
        int left_ans = kthSmallest(root.left, k);
        
        if(left_ans!=-1)   return left_ans;
        
        index++;
        if(index == k)
        {
            return root.val;
        }
        
        int right_ans = kthSmallest(root.right, k);
        if(right_ans!=-1)   return right_ans;
        
        
        return -1;
    }
    public static void main(String[] args) {
        TreeNode root = null;
        
        root           = new TreeNode(1,null,null);
        root.right     = new TreeNode(2,null,null);
        
        
        System.out.println(kthSmallest(root,2));

    }

}
