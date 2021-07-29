package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class SqrtX {

    public static int sqrt_helper(int x, int low,int high)
    {
        int result = -1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            if(mid>x/mid)
            {
                high = mid-1;
            }
            else if(mid<x/mid)
            {
                result = mid;
                low    = mid+1;
            }
            else
            {
                result= mid;
                break;
            }
        }
        
        return result;
    }
    public static int sqrt(int x)
    {
        if(x == 0)  return x;
        
        return sqrt_helper(x,1,x);
    }
    public static void main(String[] args) {

        int x = 2;
        
        System.out.println(sqrt(x));

    }

}
