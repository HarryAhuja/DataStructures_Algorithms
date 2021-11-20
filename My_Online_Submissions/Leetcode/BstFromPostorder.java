package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class BstFromPostorder {
    
    static int index = 0;
    
    public static void print_tree(TreeNode root)
    {
        if(root == null)    return;
        
        print_tree(root.left);
        System.out.print(root.val+" ");
        print_tree(root.right);
    }
    
    
    public static TreeNode bstFromPostorderHelper(int[] preorder, int min,int max)
    {
        
        if(index<0 || preorder[index]<min || preorder[index]>max)    return null;
        
        int value = preorder[index--];
        TreeNode root = new TreeNode(value);
        
        root.right = bstFromPostorderHelper(preorder,value+1,max);
        root.left  = bstFromPostorderHelper(preorder,min,value-1);
        
        
        return root;
    }
    public static TreeNode bstFromPostorder(int[] postorder)
    {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        int n = postorder.length;
        
        if(n==0)    return null;
        
        index = n-1;
       
        return bstFromPostorderHelper(postorder, min,max);

    }
    
    public static void main(String[] args) {
        int inp[] = {1, 7, 5, 50, 40, 10};
        TreeNode root = bstFromPostorder(inp);
        print_tree(root);

    }

}
