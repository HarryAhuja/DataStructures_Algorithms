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

    public static void bstFromPreorderHelper(int[] preorder,int n,TreeNode current, 
                                          int min,int max)
    {
        if(index>=n)    return;
        
        int value = preorder[index];
        if(value>=min && value<=max && value<=(current.val))
        {
            current.left = new TreeNode(value);
            index++;
            bstFromPreorderHelper(preorder,n,current.left,min,current.val-1);
        }
        
        /*
         * Again checking and updating value is performed bcs above call to
         * left in chaining can cause index to go out of bounds and value
         * to be changed
         * 
         * Suppose at root there was some min and max and value lies in that range
         * So we put that value to left child
         * not index++ and value changed. Now it doesn't come in that range
         * bcs value is to be placed in another child of some another root
         * Therefore again check if new value is in range or not
         * if not then backtrack
         * 
         */
        
        if(index>=n)    return;
        value = preorder[index];
        
        if(value>=min && value<=max && value>=(current.val))
        {
            current.right = new TreeNode(value);
            index++;
            bstFromPreorderHelper(preorder,n,current.right,current.val+1,max);
        }
    }
    public static TreeNode bstFromPreorder(int[] preorder)
    {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        int n = preorder.length;
        
        if(n==0)    return null;
        
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        
        bstFromPreorderHelper(preorder,n,root,min,max);
        
        return root;
    }
    
    public static void main(String []a)
    {
        int inp[] = {15,13,12,18};
        TreeNode root = bstFromPreorder(inp);
        print_tree(root);
        
    }
}
