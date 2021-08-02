package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class BuySellStock {
    
    public static int max_profit(int inp[])
    {
        int n = inp.length;
        
        if(n == 0 || n==1)  return 0;
        
        
        int max_profit = 0;
        
        int valley = 0;
        int peak   = 0;
        int i = 0;
        
        while(i<n)
        {
            valley = inp[i];                // Consider current element as valley
            i++;
            
            while(i<n && inp[i]>=inp[i-1])
            {
                i++;
            }
            
            if(i == n)  break;

            peak = inp[i-1];                // Find peak
            
            max_profit += (peak-valley);
        }
        
        peak = inp[i-1];                    // If peak is last element
        
        max_profit += (peak-valley);
        
        return max_profit;
    }

    public static void main(String[] args) {
        int inp[]= {1,2,3,4};
        
        System.out.println(max_profit(inp));

    }

}
