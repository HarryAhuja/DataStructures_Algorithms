package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Comparator;
import java.util.TreeMap;

// Since comparison is between homogenous keys, only
// one Integer is allowed in Comparator generics
// Always remember if we do like it will be sorted
// based on keys, I1 and I2 both are keys
class IntegerComparator implements Comparator<Integer>   
{
    public int compare(Integer i1,Integer i2)
    {
        // Adding i1
        // Already in map i2
        // compare(i1,i2)
        return i1-i2; // i1 comes first
    }
}

public class TopKFrequentElements {
    public static int[] top_k_frequent_elements(int inp[],int k)
    {
        int result[] = new int[k];
        int n        = inp.length;
        
        if(n==0)    return result;
        
        TreeMap<Integer,Integer> map = new TreeMap<>(new IntegerComparator());
        
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(inp[i])==false)
            {
                map.put(inp[i], 1);
            }
            else
            {
                int freq = map.get(inp[i]);
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        
        int nums[] = {1,1,1,2,2,3}, k = 2;
        
        int result[] = top_k_frequent_elements(nums,k);
        
        for(int i=0;i<k;i++)
            System.out.println(result[i]);
    }

}
