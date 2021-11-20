package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashSet;

public class TwoSumBST {

    static HashSet<Integer> hs = new HashSet<Integer>();
    
    public static void two_sum_bst(TreeNode root,int sum,int arr[])
    {
        if(root==null)  return;
        
        /*
         *  Putting below condition ensures to skip this condition(root.val*2)!=sum
         *  Suppose sum=10
         *  if we add 5 and then check if sum-5 is available then we need to put 
         *  *2 condition but that slows the time
         *  
         *  So better to put set condition first
         */
        if(hs.contains(sum-root.val))
        {
            arr[0] = root.val;
            arr[1] = sum-root.val;
            return;
        }
        
        hs.add(root.val);
        
        
        
        two_sum_bst(root.left,sum,arr);
        two_sum_bst(root.right,sum,arr);
    }
    public static void main(String[] args) {
        TreeNode root   = new TreeNode(15);
        root.left        = new TreeNode(10); 
        root.right       = new TreeNode(20);
        root.left.left   = new TreeNode(8);
        root.left.right  = new TreeNode(12);
        root.right.left  = new TreeNode(16);
        root.right.right = new TreeNode(25);

        int arr[] = new int[2];
        two_sum_bst(root,28,arr);
        
        System.out.println(arr[0]+" "+arr[1]);
        
    }

}
