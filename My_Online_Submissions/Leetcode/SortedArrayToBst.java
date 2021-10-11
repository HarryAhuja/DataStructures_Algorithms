package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class SortedArrayToBst {

    public static TreeNode sorted_array_to_bst_helper(int nums[],int low,int high)
    {
        if(low>high)    return null;
        
        int mid = low + (high-low)/2;
        
        TreeNode root = new TreeNode(nums[mid],null,null);
        
        root.left  = sorted_array_to_bst_helper(nums,low,mid-1);
        root.right = sorted_array_to_bst_helper(nums,mid+1,high);
        
        return root;
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
       
        if(nums.length == 0)    return null;
        
        return sorted_array_to_bst_helper(nums,0,nums.length-1);
    }
    public static void main(String[] args)
    {
        int nums[] = {-10,-3,0,5,9};
        
        System.out.println(sortedArrayToBST(nums));
    }

}
