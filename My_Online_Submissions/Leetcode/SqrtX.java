package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class SqrtX {

    public static int sqrt_helper(int x, int low,int high, int last_seen)
    {
        if(low>high)    return last_seen;
        
        
        int mid = low + (high-low)/2;
        
        if(mid>x/mid)
        {
            return sqrt_helper(x,low,mid-1,last_seen);
        }
        else if(mid<x/mid)
        {
            return sqrt_helper(x,mid+1,high,mid);
        }
        else
        {
            return mid;
        }
        
    }
    public static int sqrt(int x)
    {
        if(x == 0)  return x;
        
        return sqrt_helper(x,1,x,-1);
    }
    public static void main(String[] args) {

        int x = 2;
        
        System.out.println(sqrt(x));

    }

}
