package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public int subarraySum(int[] inp, int k)
    {
        int count = 0;
        int n = inp.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        /*
         * Suppose k = 5 and array is {3,2}
         * when current element=2, 5-5(sum)=0 is already there 1 time
         * therefore count of subarrays with k=5 is 1
         */
        map.put(0, 1);
        
        if(n==0)    return 0;
        
        int prefix_sum = 0;
        
        
        for(int i=0;i<n;i++)
        {
            prefix_sum+=inp[i];
            
            if(map.containsKey(prefix_sum-k)==true)
            {
                count+=map.get(prefix_sum-k);
            }
            
            map.put(prefix_sum,map.getOrDefault(prefix_sum, 0)+1);

        }
        return count;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
