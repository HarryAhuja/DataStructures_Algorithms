package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
    
    public static int find_greater_element_index(ArrayList<Integer> inp,int target,int low,int high)
    {
        int result = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            if(target == inp.get(mid))
            {   
                return mid;
            }
            else if(target < inp.get(mid))
            {
                result = mid;
                high   = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        
        return result;
    }
    public static int longest_increasing_subsequence(int inp[])
    {
        int n = inp.length;
        if(n==0 || n==1)    return n;
        
        int result = 1;
        ArrayList<Integer> result_list = new ArrayList<Integer>();
        
        result_list.add(inp[0]);
        
        for(int i=1;i<n;i++)
        {
            int inp_e    = inp[i];
            int result_e = result_list.get(result-1);
            if(inp_e>result_e)
            {
                result_list.add(inp_e);
                result++;
            }
            else
            {
                int greater_element_index = find_greater_element_index(result_list,inp_e,0,result-1);
                result_list.set(greater_element_index, inp_e);
            }
        }
        
        return result;
    }
    public static void main(String []args)
    {
        int inp[] = {10,9,2,5,3,7,101,18};
        
        System.out.println("Length:"+longest_increasing_subsequence(inp));
    }

}
