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
        
        /*
         * In this example, small=2, big=7
         * at value 5, since it will hit 5<=big -> it means that
         * 2<5<7. 5 is in between both values otherwise
         * if 5 is on left side, first condition hit
         * if 5 is on right side of 7, then 2nd condition doesn't hit
         * bcs its in bw 2 and 7, 5 can be considered as big
         * bcs choosing less big value increases chance of finding bigger number 
         * at its right--> Greedy solution
         */
        
        int inp[]= {2,7,5,1,8};
        
        System.out.println(increasingTriplet(inp));

    }

}
