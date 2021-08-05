package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Arrays;

public class MissingNumber {

    public static int find_missing_number(int inp[])
    {
        int n = inp.length;
        
        if(n==0)    return -1;
        
        int low  = 0;
        int high = n-1;
        
        // [0,1]
        if(inp[n-1] == n-1)   return n;
        if(inp[0]   != 0)     return 0;
        
        int result = -1;
        
        Arrays.sort(inp);
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            if(inp[mid] == mid)
            {
                low = mid+1;
            }
            else if(inp[mid]>mid)
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
    public static void main(String[] args) {
        
        int inp[] = {1,2};
        
        System.out.println(find_missing_number(inp));

    }

}
