/*
 *  Greedy will not work
 *  n=12
 *  greedy will say take 9(highes)+1+1+1= 4
 *  
 *  ans is 4+4+4=3
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class PerfectSquares {
    static int dp[] = new int[10007];
   
    public static int min(int a,int b)
    {
        return a<b?a:b;
    }
    public static int numSquares(int n)
    {
        
        dp[0] = 0;
        for(int i=1;i<=n;i++)
        {
            dp[i] = Integer.MAX_VALUE;
            
            for(int j=1;j*j<=n;j++)
            {
                if(i-j*j>=0)    dp[i] = min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args)
    {
        int n = 13;
        System.out.println(numSquares(n));

    }

}
