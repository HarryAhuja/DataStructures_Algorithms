package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

class Largest_Bst_Node
{
    boolean is_bst;
    int     size;
    int     min;
    int     max;
    
    public Largest_Bst_Node(boolean bst,int s,int mi,int ma)
    {
        is_bst = bst;
        size   = s;
        min    = mi;
        max    = ma;
    }
}

public class LargestBst
{
    public static int max(int a,int b)
    {
        return a>b?a:b;
    }
    
    public static Largest_Bst_Node largest_bst_size_helper(TreeNode root)
    {
        if(root==null)
        {
            // min should be Max value bcs we have to right_ans.min with root value
            return new Largest_Bst_Node(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        
        // postorder
        Largest_Bst_Node left_ans  = largest_bst_size_helper(root.left);
        Largest_Bst_Node right_ans = largest_bst_size_helper(root.right);

        if(left_ans.is_bst && right_ans.is_bst)
        {
            if(left_ans.max>root.val || right_ans.min<root.val)
            {
                return new Largest_Bst_Node(false,max(left_ans.size,right_ans.size),0,0);
            }
            
            
            // if left/right is null then we need to return root as min or max
            // otherwise Integer.max and min will go upwards
            return new Largest_Bst_Node(true,left_ans.size+right_ans.size+1,
                                        (root.left==null)?root.val:left_ans.min,
                                        (root.right==null)?root.val:right_ans.max);
        }
        else 
        {
            return new Largest_Bst_Node(false,max(left_ans.size,right_ans.size),0,0);
        }
    
    }
    public static int largest_bst_size(TreeNode root)
    {
        return largest_bst_size_helper(root).size;
    }
    public static void main(String[] args) {
        TreeNode root   = new TreeNode(50);
        root.left        = new TreeNode(30); 
        root.right       = new TreeNode(60);
        root.left.left   = new TreeNode(5);
        root.left.right  = new TreeNode(20);
        root.right.left = new TreeNode(45);
        root.right.right  = new TreeNode(70);
        root.right.right.left  = new TreeNode(65);
        root.right.right.right  = new TreeNode(80);

        System.out.println(largest_bst_size(root));
    }

}
