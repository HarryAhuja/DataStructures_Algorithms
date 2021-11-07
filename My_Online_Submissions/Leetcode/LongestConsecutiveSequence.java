/*
 * Iterating over array is costlier than iterating over hashmap
 * in case of duplicates
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;

public class LongestConsecutiveSequence {

    public static int max(int a,int b)
    {
        return a>b?a:b;
    }
    public static int find_longest_consecutive(int nums[])
    {
        int n = nums.length;
        
        if(n==0)    return n;
        
        int result = 1;
        
        HashMap<Integer,Boolean> hm = new HashMap<>();
        
        // Store all elements
        for(int i=0;i<n;i++)
        {
            hm.put(nums[i], true);
        }
        
        //Store real start index
        for(int i=0;i<n;i++)
        {
            int key = nums[i];
            if(hm.containsKey(key-1)==true)
            {
                hm.put(key,false);
            }
        }
        
        // This two for loops are also O(n) bcs if suppose we have 5 6 7 8
        // So inside for loop will run 4 times and outer loop will only run for 5
        // bcs for other elements if condition is false.
        // So we can say that sum of all lopps will be n only
        for(int i=0;i<n;i++)
        {
            int key = nums[i];
            
            if(hm.get(key)==true)
            {
                int count = 1;
                for(int j=key+1;true;j++)
                {
                    if(hm.containsKey(j)==false)    break;
                    
                    count++;
                }
                
                result = max(result,count);
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        int nums[] = {100,4,200,1,3,2};
        System.out.println(find_longest_consecutive(nums));
    }

}
