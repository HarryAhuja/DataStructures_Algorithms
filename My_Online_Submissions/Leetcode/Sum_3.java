package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum_3 {
    public static List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        
        // a will move till third last index
        for(int i=0;i<nums.length-2;i++)
        {
            // if first element >0, its impossible to make sum zero
            // as input array is sorted
            if(nums[i]>0)   break;
            
            if(i==0 || nums[i]!=nums[i-1])
            {
                int target = -(nums[i]);
                int low    = i+1;
                int high   = nums.length-1;
                
                while(low<high)
                {
                    if(nums[low]+nums[high]==target)
                    {
                        l.add( Arrays.asList(nums[i],nums[low],nums[high]) );
                        
                        while(low<high && nums[low]==nums[low+1])   low++;
                        while(low<high && nums[high]==nums[high-1]) high--;
                        
                        //To skip last one
                        low++;
                        high--;
                    }
                    else if(nums[low]+nums[high]<target)
                    {
                        low++;
                    }
                    else
                    {
                        high--;
                    }
                    
                }
            }
        }
        return l;
    }
    public static void main(String[] args) {
        int num[]= {-1,0,1,2,-1,-4};
        
        List<List<Integer>> l = threeSum(num);
        System.out.println(l);

    }

}
