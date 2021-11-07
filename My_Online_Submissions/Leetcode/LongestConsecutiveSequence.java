package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
        
        //Iterate over only starting index
        Set<Map.Entry<Integer,Boolean>> set = hm.entrySet();
        Iterator<Map.Entry<Integer,Boolean>> itr = set.iterator();
        
        while(itr.hasNext())
        {
            Map.Entry<Integer, Boolean> e = itr.next();
            
            if(e.getValue()==true)
            {
                int count = 1;
                int key   = e.getKey();
                while(hm.containsKey(key+1)==true)
                {
                    count++;
                    key++;
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
