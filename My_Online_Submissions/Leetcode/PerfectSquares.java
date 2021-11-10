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
    static boolean first_init;
    
    public static void init()
    {
        for(int i=0;i<10007;i++)
        {
            dp[i] = -1;
        }
    }
    
    public static int min(int a,int b)
    {
        return a<b?a:b;
    }

    public static int numSquaresHelper(int n)
    {
        
        if(n<0)     return Integer.MAX_VALUE;
        if(n==0)    return 0;
        
        if(dp[n]!=-1)   return dp[n];
        
        int ans = Integer.MAX_VALUE;
        
        for(int i=1;i*i<=n;i++)
        {
            ans = min(ans,numSquaresHelper(n-(i*i))+1);
        }
        dp[n]  = ans;
        
        return ans;
        
    }
    public static int numSquares(int n)
    {
        if(first_init==false)
        {
            init();
            first_init=true;
        }
        int ans =  numSquaresHelper(n);
        return (ans==Integer.MAX_VALUE?-1:ans);
    }

    public static void main(String[] args)
    {
        int n = 13;
        System.out.println(numSquares(n));

    }

}
