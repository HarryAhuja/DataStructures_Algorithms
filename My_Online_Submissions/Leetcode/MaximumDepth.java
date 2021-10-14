package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class MaximumDepth {
    
    public static int max(int a,int b)
    {
        return a>b?a:b;
    }
    public int maxDepth(TreeNode root) {
        
        if(root == null)    return 0;
        
        int left  = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return 1+max(left,right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        maxDepth(root);
    }

}
