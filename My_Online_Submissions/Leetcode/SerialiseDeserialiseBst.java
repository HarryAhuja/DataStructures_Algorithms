package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SerialiseDeserialiseBst
{

    // Make it complete tree for easiness in decoding
    public String serialize(TreeNode root) {
       
     // Total nodes can be 10^4
        // make string builder bcs of concatenation and give max capacity
        // later on trim
        StringBuilder sb = new StringBuilder(1000000);
        // ArrayDeque doesn't allow null insertion bcs various methods also
        // uses null as a return value/flag
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if(root==null)  return new String(sb);
        
        q.offer(root);
        
        while(q.isEmpty()==false)
        {
            TreeNode front = q.poll();
            
            // For level order, null checking should be done here
            // not while putting in queue
            if(front==null) sb.append("#,");
            else
            {
                sb.append(front.val+"");
                q.offer(front.left);
                q.offer(front.right);
            }

            
        }
        sb.trimToSize();
        return new String(sb);
    }

    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        //1,2,3,#,#,4,5,#,#,#,#, 
        if(data.equals("")) return null;
        

        String tokens[] = data.split(",");
        
        // single value can be of multiple digits. So tokenise it
        
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0])); 
        q.offer(root);
        int i = 1;
        
        while(q.isEmpty()==false)
        {
            TreeNode front = q.poll();
            
            if(tokens[i].equals("#")==false)
            {
                front.left = new TreeNode(Integer.parseInt(tokens[i]));
                q.offer(front.left);
                
            }
            i++;
            // no need of else case bcs default left is null
            // but i++ should be done in both cases
            
            if(tokens[i].equals("#")==false)
            {
                front.right = new TreeNode(Integer.parseInt(tokens[i]));
                q.offer(front.right);
            }
            i++;
        }
         
        return root;

    }
}
