/*
 *  Greedy will not work
 *  n=12
 *  greedy will say take 9(highes)+1+1+1= 4
 *  
 *  ans is 4+4+4=3
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class PerfectSquares {
    public static int min(int a,int b)
    {
        return a<b?a:b;
    }

    public static int numSquaresHelper(int n,int level)
    {
        if(n<0)     return Integer.MAX_VALUE;
        if(n==0)    return level;
        
        int ans = Integer.MAX_VALUE;
        
        for(int i=1;i*i<=n;i++)
        {
            ans = min(ans,numSquaresHelper(n-(i*i), level+1));
        }
        
        return ans;
        
    }
    public static int numSquares(int n)
    {
        int ans =  numSquaresHelper(n, 0);
        return (ans==Integer.MAX_VALUE?-1:ans);
    }

    public static void main(String[] args)
    {
        int n = 12;
        System.out.println(numSquares(n));

    }

}
