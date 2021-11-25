/*
 * "abcdbcbb";
 * 
 *  when i am at index=4(b), then if i b is repeating but if i just slide the window
 *  1 step(start a is removed), then b is still there which is hinder my requirement
 *  so i need to remove all chars till last seen b bcs i can't make unique substring
 *  with current b without removing all chars till last seen b(bcs its substring)
 *  I can't do just like this acdb
 *  
 *  So in hashmap store index where it was seen
 *  
 *  But just jumping start pointer will not be enough
 *  All chars till last seen b should also be removed from hashmap
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeat {
    
    public static int lengthOfLongestSubstring(String s)
    {
        int n = s.length();
        
        if(n==0)    return 0;
        if(n==1)    return 1;
        
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(s.charAt(i))==true)
            {
                int end = map.get(s.charAt(i));
                for(int j=start;j<=end;j++)
                {
                    map.remove(s.charAt(j));
                }
                
                start = end+1;
            }
            
            map.put(s.charAt(i), i);
            max = Math.max(max, i-start+1);
        }
        return max;
    }
    public static void main(String[] args) {
        
        String s = "abcdbabb";
        System.out.println(lengthOfLongestSubstring(s));

    }

}
