/*
 * TC
 * 1.) [-2]-> single element
 * 2.) [0,2] -> For 2 it is not going into second loop and not being compared
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class LargestProductSubarray {
    public static int max(int a,int b)
    {
        return a>b?a:b;
    }
    public static int maxProduct(int[] nums)
    {
        int n = nums.length;
        
        if(n==0)    return 0;
        if(n==1)    return nums[0];
        
        int result = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++)
        {
            // start from i itself so that single element must also 
            // be compared with result
            int product = 1;
            for(int j=i;j<n;j++)
            {
                product = product*nums[j];
                
                // if 1 element this, will not go into this for loop
                // check case separately
                result = max(result,product);
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        int nums[]= {-2,0,-1};
        System.out.println(maxProduct(nums));
    }

}
