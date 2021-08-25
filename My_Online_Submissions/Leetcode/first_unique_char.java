/*
 * Approach 1:
 * Start from last index and update the ans if its not in has map
 * last stored ans will be the required ans
 * Failed for "dddccdbba"
 * 
 * Time complexity : 2*O(n) where n is 10^5
 * Space complexity: 32bits as only lower alphabets are there
 * 
 * Approach 2:
 * Iterate from left to right
 * Update when first time char is seen
 * But this will give last unique char in string
 * Failed At : "dddccdbbae"
 * 
 * How to check kth Set bit
 * 1.) Right shift by k bits and then bitwise AND with 0x1
 * 2.) Left shift 1 by k bits and take bitwise AND
 * 
 * How to set kth bit
 * n = n | (1<<k);
 * 
*/
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;


import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class first_unique_char
{
    public static int firstUniqChar(String s) {
        
        int len = s.length();
        
        if(0 == len)    return -1;

        LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
        
        for(int i=0;i<len;i++)
        {
            char c = s.charAt(i);
            if(map.containsKey(c))
            {
                // Here exact index of duplicate is not required.
                // Need only to check if freq >=2, hence duplicate and index=-1
                map.put(c, -1);     
            }
            else
            {
                map.put(c,i);
            }
        }

        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> itr = set.iterator();
        
        while(itr.hasNext())
        {
            // Since we already gave generic in Iterator
            // itr.next() will return same. No need of type casting
            Map.Entry<Character, Integer> e = itr.next();
            Integer index = e.getValue();
            
            if(index!=-1)    return index;
        }
        
        return -1;
        
    }
    public static void main(String[] args)
    {
        String inp;

        //inp = new String("leetcode");
        //inp = new String("aabb");
        //inp = new String("bd");
        inp = new String("dddccdbba");

        System.out.println(firstUniqChar(inp));
    }
}