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

    public static int max(int a,int b)
    {
        return a>b?a:b;
    }
    public static int rob_helper(int nums[],int n)
    {
        int b = 0;
        int a = nums[0];
        // in case n<2
        int c = a;
        for(int i=2;i<=n;i++)
        {
            c = max(a,nums[i-1]+b);
            b = a;
            a = c;
            
        }
        return c;
    }
    public static int rob(int[] nums)
    {
        
        return rob_helper(nums,nums.length);
    }
    public static void main(String[] args) {
        int nums[] = {2,7,9,3,1};
        
        System.out.println(rob(nums));

    }

}
