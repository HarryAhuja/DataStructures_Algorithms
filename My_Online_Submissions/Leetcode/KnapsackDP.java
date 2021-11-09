package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class KnapsackDP {

    public static int max(int a,int b)
    {
        return a>b?a:b;
    }
    public static int max_profit(int wts[],int prices[],int n,int w)
    {
        // there are no items available
        if(n==0)    return 0;
        // back has no space to fill
        if(w==0)    return 0;
        
        int include = 0, exclude = 1;
        
        exclude = max_profit(wts,prices,n-1,w);
        
        // this condition is important here. Do make base case w<0 for this bcs
        // then function will return 0 but prices[n-1]+0, if this is greater than 
        // exclude then it will be a problem since, condition is saying bag remaining
        // capacity is less than item price, so don't include item but taking prices[n-1]
        // means we are taking item. So its wrong
        // always make base case out of it if only function call is there. No other 
        // expression is includeded(prices[n-1]) in it
        if(w-wts[n-1]>=0)   include = prices[n-1]+max_profit(wts,prices,n-1,w-wts[n-1]);
        
        return max(exclude,include);
        
    }
    public static void main(String[] args) {
        
        int wts[] = {2,7,3,4};
        int prices[] = {5,20,20,10};
        int n = 4;
        int w = 11;
        
        System.out.println(max_profit(wts,prices,n,w));

    }

}
