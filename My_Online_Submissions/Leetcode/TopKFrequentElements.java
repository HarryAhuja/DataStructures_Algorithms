/*
 * OR
 * After putting in map
 * make a list of entries and sort the list on freq param
 * of the entry
 * 
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Set;


public class TopKFrequentElements {
    public static int[] top_k_frequent_elements(int inp[],int k)
    {
        int result[] = new int[k];
        int n        = inp.length;
        
        if(n==0)    return result;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(inp[i])) map.put(inp[i], map.get(inp[i])+1);
            else                        map.put(inp[i],1);
        }
        
        
        // Max freq of a element can be total length of input array
        List<Integer> hash_db[] = new List[inp.length+1];
        
        for(int i:map.keySet())
        {
            int freq = map.get(i);
            
            // ArrayList since insertion is at last
            if(hash_db[freq] == null)   hash_db[freq] = new ArrayList<>();
            
            hash_db[freq].add(i);
        }
        
        int count = 0;
        for(int i=hash_db.length-1;i>=0;i--)
        {
            if(hash_db[i]!=null)
            {
                List<Integer> list = hash_db[i];
                int list_size      = list.size();
                int j              = 0;
                
                for(j=0;j<list_size && count+j<k;j++)
                {
                    result[count+j] = list.get(j);
                }
                
                count+=j;
                
                if(count>=k)    break;
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        
        int nums[] = {1,1,2,2,3,3,4}, k = 2;
        
        int result[] = top_k_frequent_elements(nums,k);
        
        for(int i=0;i<k;i++)
            System.out.println(result[i]);
    }

}
