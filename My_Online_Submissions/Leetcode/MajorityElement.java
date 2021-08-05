package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Arrays;

public class MajorityElement {
    
    public static int majority_element(int inp[])
    {
        int n = inp.length;
        
        if(n == 0)      return -1;
    
        Arrays.sort(inp);
        
        int i = 1;
        int count = 1;
        
        while(i<n)
        {
            if(inp[i]==inp[i-1])
            {
                count++;
                if(count>n/2)   return inp[i];
            }
            else
            {
                count = 1;
            }
            i++;
        }
        
        // if n==1, then while loop will not execute
        // Single element will be majority
        return inp[0];
    }

    public static void main(String[] args) {
        
        int inp[] = {2,2,1,1,1,2,2};
        
        System.out.println(majority_element(inp));
    }

}
