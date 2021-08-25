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
 * 
 * Approach 3:
 * Linked hashmap for maintaining insertion order
 * 
 * Approach 4:
 * store index in 256 array
 * iterate over 256 and get the minimum index of freq=1
 * 
 * Here we don't need freq exactly
 * Store -1 when freq >=2 as a flag
 * So 1d array of index only is enough
 * 
*/
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;


import java.util.Arrays;
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

        int index_arr[] = new int[26];
        
        // Dont fill with this -1 bcs -1 is the flag for freq>=2
        // you can't differentiate bw initial and freq>=2 case
        Arrays.fill(index_arr, len);
        
        for(int i=0;i<len;i++)
        {
            int ascii_offset = s.charAt(i)-'a';
            
            if(index_arr[ascii_offset] == len)      index_arr[ascii_offset] = i;
            else if(index_arr[ascii_offset]!=len)   index_arr[ascii_offset] = -1;
        }
        
        int ans = len;
        for(int i=0;i<26;i++)
        {
            if(index_arr[i]!=-1 && index_arr[i]!=len)    ans = Math.min(ans, index_arr[i]);
        }
        
        return (ans==len)?-1:ans;
        
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