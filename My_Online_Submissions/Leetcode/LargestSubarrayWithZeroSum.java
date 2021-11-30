package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;

public class LargestSubarrayWithZeroSum {

    public static int find_largest_subarray(int inp[])
    {
        int max = 0;
        int n = inp.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        
        if(n==0)    return 0;
        
        int prefix_sum = 0;
        
        for(int i=0;i<n;i++)
        {
            prefix_sum+=inp[i];
            
            if(map.containsKey(prefix_sum))
            {
                //dont update index when again seen for largest
                
                if(prefix_sum==0)
                {
                    max = Math.max(max, i+1);
                }
                else
                {
                    int index = map.get(prefix_sum);
                    max = Math.max(max, i-index); 
                }
                
            }
            else
            {
                
                map.put(prefix_sum, i);
            }
        }
        return max;
    }
    public static void main(String[] args) {

        int inp[] = {2,8,-3,-5,2,-4,6,1,2,1,3,4};
        
        System.out.println(find_largest_subarray(inp));

    }

}
