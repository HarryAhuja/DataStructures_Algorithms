package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class MoveZeroes {
    public static void swap(int nums[],int a,int b)
    {
        int temp = nums[a];
        nums[a]  = nums[b];
        nums[b]  = temp;
     }
    public static void moveZeroes(int[] nums)
    {
        int index = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                swap(nums,index,i);
                index++;
            }
        }
    }
    public static void main(String[] args) {
        int nums[]= {0,1,0,3,12};
        moveZeroes(nums);
        
        for(int i=0;i<nums.length;i++)
            System.out.print(nums[i]+" ");

    }

}
