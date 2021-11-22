package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Stack;

public class PreorderWithoutRec {
    
    public static void iterative_preorder(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(true)
        {
            if(root!=null)
            {
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }
            else
            {
                if(stack.isEmpty()==true)   break;
                
                root = stack.pop();
                root = root.right;
            }
        }
    }
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree = new TreeNode(10);
        tree.left = new TreeNode(8);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(2);
        iterative_preorder(tree);

    }

}
