/*
 *   Sum from 0 to n
 *   Subtract all numbers. Remaining would be the answer
 *   
 *   index  0+1+2+3+4
 *   inp[i] 0+1+ +3+4
 *   
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Arrays;

public class MissingNumber {

    public static int find_missing_number(int inp[])
    {
        int n = inp.length;
        
        if(n==0)    return -1;
        
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            sum +=i;
            sum -=inp[i];
        }
        
        return sum+n;
    }
    public static void main(String[] args) {
        
        int inp[] = {0,1,3};
        
        System.out.println(find_missing_number(inp));

    }

}
