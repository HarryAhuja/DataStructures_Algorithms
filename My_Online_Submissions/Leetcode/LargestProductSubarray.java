/*
 * When all no are positive, then product will be always increasing
 * 
 * When consecutive negative numebers, then sign will be alternative
 * 
 * DP
 * [-1,-2,-3]
 * Get answer of sub problem of -1,-2
 * and then use -3 on top of that
 * 
 * max of subarray = 2
 * min of subarray = -2
 * 
 * We can't skip -3 bcs of its subarray(consecutive)
 * so taking -3 with max = -6
 * taking    -3 with min = 6
 * 
 * When negative numeber is there, we required min element also bcs more is the 
 * negative number, smaller the value is. So take min(more magnitude with negative sign)
 * 
 * If we encounter 0, then taking 0 in subarray means product is 0
 * -> we can start a fresh start from next element
 * 
 * TC 
 * {-1,8}
 * max = -1
 * min = -1
 * 8*max , 8*min are less than 8 itself.
 * So it should be
 * max(current,current*max,current*min)
 */
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
        if(n==1)    return nums[0];
        
        int result = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++)
        {
            // start from i itself so that single element must also 
            // be compared with result
            int product = 1;
            for(int j=i;j<n;j++)
            {
                product = product*nums[j];
                
                // if 1 element this, will not go into this for loop
                // check case separately
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
