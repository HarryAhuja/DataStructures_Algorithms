/*
 * ababacd
 * k = 3
 * freq of a is 3
 * freq of b and c<k
 * So there is no substring as a ans
 * 
 * 1st approach: just check if freq of a >=k, if yes include it
 * this is wrong bcs we need to add all a's >=k not just single a
 * including all a's>=k also include b in this case
 * so output should be 0
 * 
 * This implies that for every breakpoint,
 * individual hashmaps are neccesary not complete
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;

public class LongestSubstringWithAtLeastKRep {
    
    static public int longestSubstring(String s, int k)
    {
        int n = s.length();
        
        if(n==0 || k>n)     return 0;
        if(k==0 || k==1)    return n;
        
        int freq[] = new int[26];
        int max    = 0;
        
        for(int i=0;i<n;i++)
        {
            freq[s.charAt(i)-'a']++;
        }
        
        int i=0;
        int start = 0;
        int end   = 0;
        
        while(i<n)
        {
            
            while(i<n && (freq[s.charAt(i)-'a']<k))
            {
                i++;
            }
            
            /*
             * abcd
             * in this case start = n
             * end = 0 or some value<n
             * max = Math.max(0/positive value, end-start(negative)) = 0/positive value 
             */
            start = i;
            //i is at starting position
            
            if(i==n)    break;
            
            
            
            while(i<n && (freq[s.charAt(i)-'a']>=k))
            {
                i++;
            }
            
            
            /*
             * Before break, assign i to end
             * "aaabbb"-> i will become n
             * end = n, start=something-> calculate max after breaking from while
             * put max check after two while also-> this is the tc
             */
            // i is at ending position
            end = i;
            
            if(i==n)    break;
            
            
            
            max = Math.max(max, end-start);
        }
        max = Math.max(max, end-start);
        
        return max;
    }
    public static void main(String[] a)
    {
        System.out.println(longestSubstring("ababacd",3));
    }
}
