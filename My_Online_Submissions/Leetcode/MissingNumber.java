/*
 *   A ^ A = 0
 *   0 ^ A = A
 *   
 *   suppose 2 is missing
 *   index = 0 1 2 
 *   value = 0 1 3
 *   
 *   if we xor indices from 0 to n and available values, missing will be left
 *   (0^1^2^3)^0^1^3=2
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Arrays;

public class MissingNumber {

    public static int find_missing_number(int inp[])
    {
        int n = inp.length;
        
        if(n==0)    return -1;
        
        int result = 0;
        for(int i=0;i<n;i++)
        {
            result^=inp[i];
            result^=i;
        }
        result^=n;      // xor with nth index
        
        return result;
    }
    public static void main(String[] args) {
        
        int inp[] = {0,1,3};
        
        System.out.println(find_missing_number(inp));

    }

}
