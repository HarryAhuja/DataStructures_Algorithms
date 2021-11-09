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
        // Don't return 0 bcs min(0,any positive) = 0 // wrong
        if(amount<0)    return Integer.MAX_VALUE;
        // return 0 here since amount==0 means exact coins are subtrated
        if(amount==0)   return 0;
        
        if(dp[amount] !=-1) return dp[amount];
        
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int sub_ans = min_coins(coins,n,amount-coins[i]);
            // sub_ans can be Integer.MAX value
            // adding 1 will make it negative and min
            // so add check condition
            if(sub_ans!=Integer.MAX_VALUE) ans = min(ans,sub_ans+1);
        }
        
        dp[amount] = ans;
        /*
         * Don't think we need hashmap to check 
         * for ex
         * amount remaining is 7, then if we have exact coin as 7 then return 1 coin
         * 
         * no of coins needed to make 22 from 21,15,12 is 1+sub_ans bcs we have exact
         * 1 coin needed to make 22 from these number
         *              22
         *         21   15  12
         * 
         */
        
        return dp[amount];
    }
    public static void main(String[] args) {
        int coins[] = {1,7,10};
        int n       = 3;
        int amount  = 15;
        
        init();
        System.out.println(min_coins(coins,n,amount));

    }

}
