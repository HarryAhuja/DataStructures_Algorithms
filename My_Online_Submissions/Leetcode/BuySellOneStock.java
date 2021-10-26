/*
 *  Space = O(n)
 *  Time  = O(2n)
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class BuySellOneStock
{
    public static int max(int a,int b)
    {
        return a>b?a:b;
    }
    
    public static int maxProfit(int[] prices)
    {
        int n = prices.length;
        
        if(n==0)    return 0;
        
        int aux[]  =  new int[n];
        aux[n-1]  = prices[n-1];
        
        for(int i=n-2;i>=0;i--)
        {
            aux[i] = max(aux[i+1],prices[i]);
        }
        
        int result = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            result = max(result,aux[i]-prices[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int inp[]= {7,1,5,3,6,4};
        System.out.println(maxProfit(inp));
    }

}
