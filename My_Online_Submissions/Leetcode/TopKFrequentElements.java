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
import java.util.PriorityQueue;
import java.util.Set;

class FreqNode
{
    int key;
    int freq;
    
    public FreqNode()
    {
        key  = -1;
        freq = 0;
    }
    
    public FreqNode(int k,int f)
    {
        key  = k;
        freq = f;
    }
}

class CustomComparator implements Comparator<FreqNode>
{
    @Override
    public int compare(FreqNode o1, FreqNode o2) {
        return o2.freq-o1.freq;
    }
    
}

public class TopKFrequentElements {
    public static int[] top_k_frequent_elements(int inp[],int k)
    {
        int result[] = new int[k];
        int n        = inp.length;
        
        if(n==0)    return result;
        
        PriorityQueue<FreqNode> pq = new PriorityQueue<>(inp.length,new CustomComparator());
        
        HashMap<Integer,Integer> map = new HashMap<>();
                
        for(int i=0;i<n;i++)
        {
           map.put(inp[i],map.getOrDefault(inp[i],0)+1);
        }
        
        Set<Integer> s = map.keySet();
        Iterator<Integer> itr = s.iterator();
        
        while(itr.hasNext())
        {
            Integer i = itr.next();
            pq.offer(new FreqNode(i,map.get(i)));
        }
        
        while(k>0 && pq.isEmpty()==false)
        {
            FreqNode f = pq.poll();
            result[k-1] = f.key;
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
