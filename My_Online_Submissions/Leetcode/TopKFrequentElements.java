/*
 * Inp can contain negative numbers
 * 1.) either make hashmap, will take care
 * 2.) use modulus for array freq hashmap. Make use of java
 *     go for 1
 * 
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

class CustomComparator implements Comparator<Map.Entry<Integer, Integer>>
{
    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o2.getValue()-o1.getValue();
    }
}

public class TopKFrequentElements {
    public static int[] top_k_frequent_elements(int inp[],int k)
    {
        int result[] = new int[k];
        int n        = inp.length;
        
        if(n==0)    return result;
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(inp.length,new CustomComparator());
        
        HashMap<Integer,Integer> map = new HashMap<>();
                
        for(int i=0;i<n;i++)
        {
           map.put(inp[i],map.getOrDefault(inp[i],0)+1);
        }
        
        
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> itr=set.iterator();
        
        while(itr.hasNext())
        {
            Map.Entry<Integer, Integer> e = itr.next();
            pq.offer(e);
        }
        
        while(k>0 && pq.isEmpty()==false)
        {
            Map.Entry<Integer, Integer> e = pq.poll();
            result[k-1] = e.getKey();
            k--;
        }
        
        return result;
    }
    public static void main(String[] args) {
        
        int nums[] = {-1,-1}, k = 1;
        
        int result[] = top_k_frequent_elements(nums,k);
        
        for(int i=0;i<k;i++)
            System.out.println(result[i]);
    }

}
