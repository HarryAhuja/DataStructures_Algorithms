package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Set;

class IntegerComparator implements Comparator<Node>
{
    @Override
    public int compare(Node o1, Node o2) {
        return o2.freq-o1.freq;
    }
}

class Node 
{
    int key;
    int freq;
    
    public Node()
    {
        key  = -1;
        freq = 0;
    }
    public Node(int k,int f)
    {
        key  = k;
        freq = f;
    }
    public String toString()
    {
        return "key="+this.key+" freq="+this.freq;
    }
}

public class TopKFrequentElements {
    public static int[] top_k_frequent_elements(int inp[],int k)
    {
        int result[] = new int[k];
        int n        = inp.length;
        
        if(n==0)    return result;
        
        TreeMap<Integer,Integer> map= new TreeMap<>();
        
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(inp[i])) map.put(inp[i], map.get(inp[i])+1);
            else                        map.put(inp[i],1);
        }
        
        Set<Integer>        s    = map.keySet();
        Iterator<Integer>   itr  = s.iterator();
        ArrayList<Node>     list = new ArrayList<>();
        int                 keys = 0;
        
        while(itr.hasNext())
        {
            Integer key = itr.next();
            Integer val = map.get(key);
            list.add(new Node(key,val));
            keys++;
        }
        // This is not applicable to custom class
        //Arrays.sort(list);
        //Collections.sort(list)
        // For custom class, use below and make another
        // class for comparator. Don't implement in node
        Collections.sort(list,new IntegerComparator());
       
        for(int i=0;i<k;i++)
        {
            result[i] = list.get(i).key;
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
