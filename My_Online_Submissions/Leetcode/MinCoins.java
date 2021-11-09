package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class MinCoins {
    
    static int dp[] = new int[100000];
    
    public static void init()
    {
        for(int i=0;i<100000;i++)   dp[i] = -1;
    }
    
    public static int min(int a,int b)
    {
        return a<b?a:b;
    }

    public static int min_coins(int coins[],int n,int amount)
    {
        if(amount<=0)   return 0;
        
        dp[0] = 0;
        
        for(int i=1;i<=amount;i++)
        {
            dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<n;j++)
            {
                if(i-coins[j]>=0 )
                {
                    // If amount is 6/8, and we have coins as 7,10
                    // then ans will be stored as max value
                    if(dp[i-coins[j]]!=Integer.MAX_VALUE)
                        dp[i] = min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        
        return dp[amount];
    }
    public static void main(String[] args) {
        int coins[] = {1,7,10};
        int n       = 3;
        int amount  = 15;
        
        
        System.out.println(min_coins(coins,n,amount));

    }

}
