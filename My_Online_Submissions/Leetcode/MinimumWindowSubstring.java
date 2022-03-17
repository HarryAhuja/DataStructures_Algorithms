package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;

public class MinimumWindowSubstring
{
    public static void main(String a[])
    {
        String s = "ADOBECODEBANC", t = "ABC";
        
        String ans = new String();
        String potentialAnswer = new String();
        HashMap<Character, Integer> pattern = new HashMap<>();
        HashMap<Character, Integer> local = new HashMap<>();
       
        
        for(int i=0;i<t.length();i++)
        {
            char c = t.charAt(i);
            pattern.put(c, pattern.getOrDefault(c, 0)+1);
        }
        
        
       
        int i = 0;
        int n = s.length();
        int count = t.length();
        
        int start = 0;
        
        
        int matchCount = 0;
        
        while(i<n)
        {
            // acquiring
            while(i<n && matchCount!=count)
            {
                char c = s.charAt(i);
                
                local.put(c, local.getOrDefault(c, 0)+1);
                 
                if(local.getOrDefault(c,0)<=pattern.getOrDefault(c,0))
                {
                    matchCount++;
                }
                i++;
            }
            
           
            
            while(start<=i && matchCount==count)
            {
                potentialAnswer = s.substring(start,i);
                if(ans.length()==0 || potentialAnswer.length()<ans.length())
                {
                    ans = new String(potentialAnswer);
                }
                
                char c = s.charAt(start);
                start++;
                
                if(local.get(c)==1)
                {
                    local.remove(c);
                }
                else
                {
                    local.put(c, local.get(c)-1);
                }
                
                if(local.getOrDefault(c,0)<pattern.getOrDefault(c,0))
                {
                   matchCount--;
                }
            }
         }
        System.out.println(ans);
    }
}
