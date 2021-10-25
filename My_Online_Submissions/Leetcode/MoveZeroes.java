/*
 * Filling zeroes vs swapping
 * 
 * 2.) 1,0,2,13
 *     0 is swapped with 2
 *     1,2,0,13
 *     0 is swapped with 13
 *     
 *     So firstly 0 is swapped and then again some other number replaced it
 *     we are unnecessary swapping first
 *     
 * 1.) First approach doesn't do this. it writes only single time 0 at last
 * 
 */
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
