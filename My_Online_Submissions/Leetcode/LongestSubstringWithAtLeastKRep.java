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
 * ababacd
 * it says that a can be included in any substring but can we include it
 * in "a"b
 * No, bcs this substring as only one occurrence of a not >=k
 * 
 * 2nd approach
 * 
 * ------------b------------
 * <---s1-----> <----s2---->
 * 
 * Suppose in full string(s), b is the breakpoint only
 * and somehow we have starting and ending limits of s1 and s2
 * Get longest substring from s1 by recursion
 * Get longest substring from s2 by recursion
 * take max
 * 
 * problem in 1st approach will be solved automatically bcs asking can we include "a" in that
 * substring will return no from recursion
 * 
 * So at each call, we have to do
 * 1.) find freq of each char
 * 2.) find breakpoints
 * 3.) find limits of s1 and s2
 * 4.) do recursion
 * 
 *  In recursion, either you can use substring or use start and end limits
 *  Avoid substring
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;

public class LongestSubstringWithAtLeastKRep {
    static 
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
        
        int i = 0;
        while(i<n && (freq[s.charAt(i)-'a']<k))
        {
            i++;
        }

        // no character has >=k
        //"abcd"
        if(i==n)    return 0;
        
        
        
        while(i<n && (freq[s.charAt(i)-'a']>=k))
        {
            i++;
        }
        
        
        /
        end = i;
        
        if(i==n)    break;
        
        max = Math.max(max, end-start);
        
        
        
    }
    public static void main(String[] a)
    {
        System.out.println(longestSubstring("ababacd",3));
    }
}
