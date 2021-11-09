/*
 * Intitally for each n, we are iterating k backwards.So
 * time was O(kn)
 * 
 * But with sliding window, we don't move k backwards always
 * only subtract last and add current->O(1)
 * So time is O(n)
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class LadderDP
{
    
    public static int no_of_ways(int n,int k)
    {
        // either put condition at calling or at this point(after called)
        if(n<0)     return 0;
        if(n==0)    return 1;
        
        int dp[] = new int[100000];
        
        dp[0]   = 1;
        int sum = dp[0];
        int i   = 1;
        for(i=1;i<n && i<k;i++)
        {
            dp[i] = sum;
            sum+=dp[i];
        }
        
        // if(n<=k)
        if(i==n)    return dp[n];
        
        for(;i<=n;i++)
        {
            dp[i] = sum;
            // dp[i-1]+dp[i-2]+dp[i-3]+dp[i]-dp[i-3]
            sum   = sum+dp[i]-dp[i-k];
        }
        
        return dp[n];
    }
    public static void main(String[] args) {
       
        int n = 4, k = 3;
       
        System.out.println(no_of_ways(n,k));

    }

}
