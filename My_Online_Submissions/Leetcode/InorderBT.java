package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class InorderBT {
    public static void inorderTraversalHelper(TreeNode root,List<Integer> l) {
        if(root==null)  return;
        
        inorderTraversalHelper(root.left,l);
        l.add(root.val);
        inorderTraversalHelper(root.right,l);
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> l = new ArrayList<Integer>();
        inorderTraversalHelper(root,l);
        
        return l;
    }
    public static void main(String[] args) {
        
        List<Integer> l = inorderTraversal(new TreeNode(10));
    }

}
