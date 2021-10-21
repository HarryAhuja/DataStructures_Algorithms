/*
 * Brute force : O(n3)
 * 
 * We need two loops for limit of i and j
 * One loop to get sum from i to j
 * 
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
        
        for(int len=1;len<=n;len++)
        {
            for(int i=0;i<=n-len;i++)
            {
                int sum = 0;
                for(int j=i;j<i+len;j++)
                {
                    sum+=nums[j];
                }
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
