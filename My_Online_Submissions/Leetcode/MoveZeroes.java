package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class MoveZeroes {
    
    public static void moveZeroes(int[] nums)
    {
        int index = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                // Don't swap two same elements
                if(index!=i)    nums[index] = nums[i];
                
                // must be done in both cases
                index++;
            }
        }
        for(int i=index;i<nums.length;i++)
        {
            nums[i] = 0;
        }
    }
    public static void main(String[] args) {
        int nums[]= {1,0,2,3,12};
        moveZeroes(nums);
        
        for(int i=0;i<nums.length;i++)
            System.out.print(nums[i]+" ");

    }

}
