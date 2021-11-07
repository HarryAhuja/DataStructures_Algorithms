package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class LargestProductSubarray {
    public static int max(int a,int b)
    {
        return a>b?a:b;
    }
    public static int maxProduct(int[] nums)
    {
        int n = nums.length;
        
        if(n==0)    return 0;
        
        int result = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++)
        {
            int product = nums[i];
            for(int j=i+1;j<n;j++)
            {
                product = product*nums[j];
                
                result = max(result,product);
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        int nums[]= {-2,0,-1};
        System.out.println(maxProduct(nums));
    }

}
