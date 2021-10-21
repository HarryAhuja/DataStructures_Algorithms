/*
 * Sliding window : O(n2)
 * Advantage : for particular length, we are not looping over again
 *             over same elements
 * Disadvantage : for length n, we are not taking advantage of ans of n-1
 * 
 * TCs: 203/209 passed
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class MaximumSubarray {
    public static int max(int a,int b)
    {
        return a>b?a:b;
    }
    
    public static int maxSubArray(int[] nums)
    {
        int   n = nums.length;
        int ans = Integer.MIN_VALUE;
        
        if(n==0)    return 0;
        
        for(int len = 1;len<=n;len++)
        {
            int sum = 0;
            int i   = 0;
            //First window
            for(i=0;i<len;i++)
            {
                sum+=nums[i];
            }
            ans = max(ans,sum);
            
            while(i<n)
            {
                sum+=nums[i];
                sum-=nums[i-len];
                i++;
                ans = max(ans,sum);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
        int inp[]= {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(inp));
    }

}
