package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class LadderDP
{
    static int dp[] = new int[100000];
    public static void init()
    {
        for(int i=0;i<100000;i++)   dp[i] = -1;
    }
    
    public static int no_of_ways(int n,int k)
    {
        // either put condition at calling or at this point(after called)
        if(n<0)     return 0;
        if(n==0)    return 1;
        
        if(dp[n] !=-1)  return dp[n];
        
        int ans = 0;
        for(int i=1;i<=k;i++)
        {
            ans += no_of_ways(n-i,k);
        }
        
        dp[n]  = ans;
        
        return ans;
    }
    public static void main(String[] args) {
       
        int n = 4, k = 3;
        
        init();
        System.out.println(no_of_ways(n,k));

    }

}
