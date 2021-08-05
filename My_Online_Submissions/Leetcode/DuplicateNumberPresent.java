package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Arrays;

public class DuplicateNumberPresent {
    
    public static boolean contains_duplicate(int inp[])
    {
        Arrays.sort(inp);
        
        int n = inp.length;
        
        if(n==0 || n==1)    return false;
        
        int i = 1;
        
        while(i<n)
        {
            if(inp[i] == inp[i-1])  return true;
            else                    i++;
        }
       
        return false;
    }

    public static void main(String[] args) {
        
        int inp[] = {1,2,3,1};
        
        System.out.println(contains_duplicate(inp));

    }

}
