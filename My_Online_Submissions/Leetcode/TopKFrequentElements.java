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
        
        
        TreeMap<Integer,List<Integer>> freq_map= new TreeMap<>();
        
        Set<Integer>  key_set = map.keySet();
        Iterator<Integer> itr = key_set.iterator();
        
        while(itr.hasNext())
        {
            Integer key  =(Integer) itr.next();
            Integer freq = map.get(key);
            
            if(freq_map.containsKey(freq) == false)
            {
                freq_map.put(freq, new ArrayList<>());
            }
            freq_map.get(freq).add(key);
        }
        
        int count = 0;
        while(count<k)
        {
            Map.Entry<Integer, List<Integer>> e = freq_map.pollLastEntry();
            List<Integer> list = e.getValue();
            int list_size     = list.size();
            int i;
            
            for(i=0;i<list_size && count+i<k;i++)
            {
                result[count+i] = list.get(i);
            }
            count+=i;
        }
        
        
        return result;
    }
    public static void main(String[] args) {
        
        int nums[] = {3,0,1,0}, k = 1;
        
        int result[] = top_k_frequent_elements(nums,k);
        
        for(int i=0;i<k;i++)
            System.out.println(result[i]);
    }

}
