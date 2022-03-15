/*
 * 
 * We only need count not exact chars
 */

class Solution {
    
    static int mod = (int)Math.pow(10,9)+7;
    
    static int dp[][][] = new int[100005][3][2];
    
    public static int MaxEligibleCount(int n,int l,int a)
    {
        
        if(dp[n][l][a]!=0)
        {
            return dp[n][l][a];
        }
        
        if(n==0)
        {
            
            return 1;
        }
        
        int ans = 0;
        
        
            
        // add only if we dont have a single a
        if(a<1)
        {
            ans+=MaxEligibleCount(n-1,0,a+1);
            ans%=mod;
        }
        // can add only we have not more than 2 consecutive L's
        if(l<2)
        {
            ans+=MaxEligibleCount(n-1,l+1,a);
            ans%=mod;
            
        }
            
               
        ans+=MaxEligibleCount(n-1,0,a);
          
        ans%=mod;
        
        
        dp[n][l][a] = ans;
        
        return ans;
    }
    public int checkRecord(int n) {
        return MaxEligibleCount(n,0,0);
    }
}