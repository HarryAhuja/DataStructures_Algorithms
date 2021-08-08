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

            char char_arr[] = s.toCharArray();
            Arrays.sort(char_arr);
            
            // Convert char array into String
            String sorted_str = String.valueOf(char_arr);
            
            if(map.containsKey(sorted_str) == false)    map.put(sorted_str, new ArrayList<String>());
            
            map.get(sorted_str).add(s);
        }
        
        return new ArrayList<>(map.values());
        
    }
    public static void main(String[] args) {
        
        String str[] = {"eat","tea","tan","ate","nat","bat"};
        
        List<List<String>> result = group_anagrams(str);
        
        System.out.println(result);

    }

}

