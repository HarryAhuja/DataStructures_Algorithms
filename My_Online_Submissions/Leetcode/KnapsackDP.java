
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class KnapsackDP {

    static int dp[][] = new int[10000][10000];
    
    public static void init()
    {
        for(int i=0;i<10000;i++)
        {
            for(int j=0;j<10000;j++)
            {
                dp[i][j] = -1;
            }
        }
    }
    public static int max(int a,int b)
    {
        return a>b?a:b;
    }
    
    public static int max_profit(int wts[],int prices[],int N,int W)
    {
        // there are no items available
        if(N==0)    return 0;
        // back has no space to fill
        if(W==0)    return 0;
        
        for(int n=0;n<=N;n++)
        {
            for(int w=0;w<=W;w++)
            {
                if(w==0 || n==0)
                {
                    // base case
                    dp[n][w] = 0;
                }
                else
                {
                    if(w-wts[n-1]>=0)
                        dp[n][w] = max(dp[n-1][w],prices[n-1]+dp[n][w-wts[n-1]]);
                    // this else is necessary
                    // if current item can't be included then it must be exlucuded
                    else
                        dp[n][w] = dp[n-1][w];
                }
            }
        }
        return dp[N][W];
    } 
    public static void main(String[] args) {
        
        int wts[] = {2,2,3,1};
        int prices[] = {5,20,100,30};
        int n = 4;
        int w = 5;
      
        init();
        System.out.println(max_profit(wts,prices,n,w));

    }

}
