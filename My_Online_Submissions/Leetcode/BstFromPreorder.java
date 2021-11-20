package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class BstFromPreorder {
    
    static int index = 0;
    
    public static void print_tree(TreeNode root)
    {
        if(root == null)    return;
        System.out.print(root.val+" ");
        print_tree(root.left);
        
        print_tree(root.right);
    }

    public static TreeNode bstFromPreorderHelper(int[] preorder,int n, int min,int max)
    {
        
        if(index>=n || preorder[index]<min || preorder[index]>max)    return null;
        
        int value = preorder[index];
        TreeNode root = new TreeNode(value);
        
        root.left  = bstFromPreorderHelper(preorder,n,min,value-1);
        root.right = bstFromPreorderHelper(preorder,n,value+1,max);
        
        return root;
    }
    public static TreeNode bstFromPreorder(int[] preorder)
    {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        int n = preorder.length;
        
        if(n==0)    return null;
       
        return bstFromPreorderHelper(preorder,n, min,max);

    }
    
    public static void main(String []a)
    {
        int inp[] = {15,13,12,18};
        TreeNode root = bstFromPreorder(inp);
        print_tree(root);
        
    }
}
