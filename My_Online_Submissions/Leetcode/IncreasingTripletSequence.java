package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class IncreasingTripletSequence {
    // Only tells if sequence exist or not
    // Will not work if sequence has to be returned
    public static boolean increasingTriplet(int[] nums) {
        
        int small = Integer.MAX_VALUE;
        int big   = Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            // = is important
            // If not set, then {1,1,1,2} will return true
            // which is wrong answer
            if(nums[i]<=small)      small = nums[i];
            else if(nums[i]<=big)   big = nums[i];
            else                    return true;
        }
        
        return false;
    }
    public static void main(String[] args) {
        
        //int inp[]= {2,1,5,0,4,6};
        int inp[]= {1,1,1,2};
        
        System.out.println(increasingTriplet(inp));

    }

}
