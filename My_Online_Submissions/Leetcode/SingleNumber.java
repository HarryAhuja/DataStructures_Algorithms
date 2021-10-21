package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class SingleNumber {
    
    public static int singleNumber(int[] nums)
    {
        int ans = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            ans = ans^nums[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int inp[] = {4,1,2,1,2};
        System.out.println(singleNumber(inp));
        

    }

}
