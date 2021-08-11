package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;

public class KEqualSubset {

    public static boolean result = false;
    
    public static void is_partition_possible_helper(int inp[], int level,int n,int k,int target_sum,
                                                    int sum,boolean visited[])
    {
        // each bucket can contain different number of
        // elements so base case is not on level==n
        if(sum == target_sum)
        {
            // Elements that are used in one bucket should not
            // used again
            k--;
            
            if(k == 0)
            {
                result = true;
                return;
            }
            
            is_partition_possible_helper(inp, 0, n, k, target_sum,0,visited);
            
            return;
        }
        else if(level==n || sum>target_sum)
        {
            // if sum!=target then it will infinite loop
            // At sum point it has to stop
            return;
        }
        
        // Exclude
        is_partition_possible_helper(inp, level+1, n, k, target_sum,sum,visited);
        
        //Include
        if(visited[level] == false)
        {
            visited[level] = true;
            is_partition_possible_helper(inp, level+1, n, k, target_sum,sum+inp[level],visited);
            // No need of backtrack explicitly of sum since we are not changing any global
            // variable sum is local variable. So when this line hits, sum is not sum+inp[level]
            // But visited array is passed by reference, do explicit
            visited[level] = false;
        }
        
        
    }
    public static boolean is_partition_possible(int inp[], int k)
    {
        int total_sum     = 0;
        int n             = inp.length;
        boolean visited[] = new boolean[n];
        
        for(int i=0;i<n;i++)   total_sum+=inp[i];
        
        if(k == 0 || ((total_sum%k)!=0))
        {
            // float sum in each bucket
            return false;
        }
        
        is_partition_possible_helper(inp,0,n,k,total_sum/k,0,visited);
        
        
        return result;
    }
    public static void main(String[] args) {
        
        int inp[] = {1,1,1,1,9};
        int k     = 2;
        
        System.out.print(is_partition_possible(inp,k));
    }

}
