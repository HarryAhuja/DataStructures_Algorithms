/*
 *  Initially we are doing
 *  we are trying to buy everyday and seeing on which day we should buy such 
 *  that difference of buying and selling is max
 *  
 *   Now think of reverse
 *   We will try to sell everyday and keep track of min_so_far such that
 *   profit is max
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class BuySellOneStock
{
    public static int max(int a,int b)
    {
        return a>b?a:b;
    }
    public static int min(int a,int b)
    {
        return a<b?a:b;
    }
    
    public static int maxProfit(int[] prices)
    {
        int n = prices.length;
        
        if(n==0)    return 0;
        
        int min_so_far = Integer.MAX_VALUE;
        
        int result = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++)
        {
            min_so_far = min(min_so_far,prices[i]);
            result     = max(result,prices[i]-min_so_far);
        }
        return result;
    }
    public static void main(String[] args) {
        int inp[]= {7,1,5,3,6,4};
        System.out.println(maxProfit(inp));
    }

}
