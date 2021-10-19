/*
 * Suppose tree is
 *                       3
 *                 9          20
 *             11    10     15    7
 *             
 *   p = 3  9 11 10 20 15 7
 *   i = 11 9 10 3  15 20 7
 *   
 *   3 is root. Left of 3 is 11,9,10 from inorder but left subtree can be these
 *   
 *         3                       3                   3
 *      9                       9                    9
 *    11                     11    10              10  11
 *  10
 * 
 * So pre-order tells that 9 will be left root
 * Left subtree of 9 is 11
 * so 11 will be the root but it can case 1 or 2
 * So if 1 is the case, then 10 will be left in inorder
 * since 11 don't have left, --> case 2
 * 
 * So preorder tells what will the root
 *    inorder tells who is on left and right subtree
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class PreorderInorder {
    static int index = 0;
    
    public static TreeNode buildTreeHelper(int[] preorder, int[] inorder,int low,int high)
    {
        if(low>high)   return null;
        
        TreeNode root = new TreeNode(preorder[index++]);
        
        int root_index = 0;
        for(int i=low;i<=high;i++)
        {
            if(inorder[i] == root.val)
            {
                root_index= i;
                break;
            }
        }

        root.left     = buildTreeHelper(preorder,inorder,low,root_index-1);
        root.right    = buildTreeHelper(preorder,inorder,root_index+1,high);
        
        return root;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder)
    {
        return buildTreeHelper(preorder,inorder,0,preorder.length-1);

    }
    public static void main(String a[])
    {
        
        int preorder[] = {3,9,20,15,7}, inorder[] = {9,3,15,20,7};
        
        TreeNode res = buildTree(preorder,inorder);
        System.out.println(res.val);
        System.out.println(res.left.val);
        System.out.println(res.right.val);
        System.out.println(res.right.left.val);
        System.out.println(res.right.right.val);
    }
}
