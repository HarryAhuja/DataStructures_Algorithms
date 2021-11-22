package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderWithoutRec {
    
    public static List<Integer> iterative_preorder(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> l = new ArrayList<Integer>();
        while(true)
        {
            if(root!=null)
            {
                l.add(0,root.val);
                stack.push(root);
                // Push right first bcs we are adding from back end
                // postorder =  L->R->root
                // if adding in list from back, then root->R->L
                root = root.right;
            }
            else
            {
                if(stack.isEmpty()==true)   break;
                
                root = stack.pop();
                root = root.left;
            }
        }
        
        return l;
    }
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree = new TreeNode(10);
        tree.left = new TreeNode(8);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(2);
        System.out.println(iterative_preorder(tree));

    }

}
