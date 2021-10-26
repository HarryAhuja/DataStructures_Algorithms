/*
 * NlogN solution
 * Generate a random value between 0 and 1 for each index
 * Sort in ascending/descending order based on random value not inp[i]
 * It will give shuffled array
 * since random number generated itself is random, ascending will not matter
 * 
 * Challenge
 * Keep track of original array so that reset can be returned in O(1)
 * 
 * when shuffle is called, we can do following
 * 1.) make copy into temp and shuffle temp and then return temp
 *     This will increase time complexity of calling(but max size of array can be 200)
 * 2.) keep one shuffle array and do operation in that always Bcs shuffling on original or
 *     modifed array results in equal probability of result
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class ShuffleArray {
    
    static int original_inp[];                         // we don't the length yet
    static int shuffled_inp[];
    
    public ShuffleArray(int[] nums) {
        original_inp = new int[nums.length];   // we know length now
        shuffled_inp = new int[nums.length];   // we know length now
        
        for(int i=0;i<nums.length;i++)
        {
            shuffled_inp[i] = nums[i];
            original_inp[i] = nums[i];
        }
    }
    
    public static int[] reset()
    {
        return original_inp;
    }
    
    public static int[] shuffle()
    {
        for(int i=shuffled_inp.length-1;i>0;i--)
        {
            int max = i;        // very important //self index should be included
            int min = 0;
            int rand_index = min+(int)(Math.random()*(max-min+1));
            
            int temp = shuffled_inp[rand_index];
            shuffled_inp[rand_index] = shuffled_inp[i];
            shuffled_inp[i]          = temp;
        }
        
        return shuffled_inp;
    }
    
    public static void main(String[] args) {
        
        int nums[]= {1,2,3,4,5};
        ShuffleArray s = new ShuffleArray(nums);

    }

}
