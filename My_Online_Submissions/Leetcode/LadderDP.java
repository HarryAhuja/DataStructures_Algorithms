package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class LadderDP {

    public static int no_of_ways(int n,int k)
    {
        // Ground floor || only single way to take steps
        if(n==0 || k ==1)   return 1;
        
        //Bottom dp
        int dp[] = new int[n+1];
        dp[0] = 1;
        
        for(int ladder=1;ladder<=n;ladder++)
        {
            dp[ladder]  = 0;
            for(int i=1;i<=k;i++)
            {
                if(ladder-i>=0) dp[ladder] = dp[ladder]+dp[ladder-i];
            }
        }
        
        return dp[n];
    }
    public static void main(String[] args) {
       
        int n = 4, k = 3;
        
        System.out.println(no_of_ways(n,k));

    }

}
