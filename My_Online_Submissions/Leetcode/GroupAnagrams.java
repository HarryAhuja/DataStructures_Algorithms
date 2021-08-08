/*
 * Order doesn't matter
 * Output   = [["bat"],["eat","tea","ate"],["tan","nat"]]
 * Expected = [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * ate,eat,tea after sorting will make same aet
 * so keep aet as key and array list of 3 strings as values
 * so in map it would be
 * Key      Value
 * aet      [eat,tea,ate]
 * ant      [nat,tan]
 * abt      [bat]
 * 
 * map.values return collection view. So we can convert
 * into Array List directly
 * 
 * Encoding technique
 * Since anagrams should produce same string, therefore
 * all should have same encoded string based upon their
 * frequency. So we can have some algo which return same encoded
 * string for all anagrams. So that key would remain same
 * Currently encoding string is taking sorting of string(mlogm)
 * We should make it as O(m)
 * 
 * Use various methods for making hash code like
 * professional,KMP etc
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GroupAnagrams {
    
    public static List<List<String>> group_anagrams(String str[])
    {
        Map<String, List<String>> map = new HashMap<>();
        
        int n = str.length;
        
        if(n == 0)  return new ArrayList<>();
        
        // Sort word wise
        for(int i=0;i<n;i++)
        {
            String s = str[i];
            
            // 128 :75ms
            // 26  :17ms
            // Bcs this has to go into Arrays.toString()
            int frequency[] = new int[128];
            for(int j=0;j<s.length();j++)
            {
                frequency[s.charAt(j)-'a']++;
            }
            
            // Convert int array into String
            String encoded_str = Arrays.toString(frequency);
            
            if(map.containsKey(encoded_str) == false)    map.put(encoded_str, new ArrayList<String>());
            
            map.get(encoded_str).add(s);
        }
        
        return new ArrayList<>(map.values());
        
    }
    public static void main(String[] args) {
        
        String str[] = {"eat","tea","tan","ate","nat","bat"};
        
        List<List<String>> result = group_anagrams(str);
        
        System.out.println(result);

    }

}

