package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class SearchBst {
    
    public TreeNode searchBST(TreeNode root, int val)
    {
        if(root ==null) return root;
        
        if(root.val==val)   return root;
        
        if(val<root.val)    return searchBST(root.left,val);
        else                return searchBST(root.right,val);
    }
}
