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
        if(n<=0)    return 0;
        
        int inc = 0, exc = 0;
        
        // Can't rob i-1 if ith house is robbed
        
        // this is very tricky situtation to put n-2>=0 condition here
        // suppose 2 7 9 3 1
        // at 1,index=0-> so you want to include this number
        // but n-2<0 -> this function will not be called
        // you want to include this number but n-2 means don't want to include
        // previous number
        // so putting this condition is restricting condition
        inc = nums[n-1]+rob_helper(nums,n-2);
        exc = rob_helper(nums,n-1);
        
        return max(inc,exc);
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
