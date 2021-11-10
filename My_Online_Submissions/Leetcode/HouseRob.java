/*
 * 2,1,9,3,1,10
 * 
 * rob 9 and 10 and more(9 and 10 are not in alternative fashion)
 * 
 * In a recursive tree path, two adjacent number should not be there
 * 
 * Refer to
 * https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class HouseRob {

    static int dp[] = new int[101];
    
    public static void init()
    {
        for(int i=0;i<101;i++) dp[i] = -1;
    }
    
    public static int max(int a,int b)
    {
        return a>b?a:b;
    }
    public static int rob_helper(int nums[],int n)
    {
        dp[0] = 0;
        dp[1] = nums[0];
        
        for(int i=2;i<=n;i++)
        {
            dp[i] = max(dp[i-1],nums[i-1]+dp[i-2]);
        }
        return dp[n];
    }
    public static int rob(int[] nums)
    {
        init();
        return rob_helper(nums,nums.length);
    }
    public static void main(String[] args) {
        int nums[] = {2,7,9,3,1};
        
        System.out.println(rob(nums));

    }

}
