package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Arrays;
import java.util.Collections;

public class Anagram {

    public static boolean are_anagram(String s,String t)
    {
        char temp_s[] = s.toCharArray();
        char temp_t[] = t.toCharArray();
        
        Arrays.sort(temp_s);
        Arrays.sort(temp_t);
        
        int s_len = s.length();
        int t_len = t.length();
        
        if(t_len!=s_len)    return false;
        
        int i = 0;

        while(i<s_len)
        {
            if(temp_s[i]!=temp_t[i])
            {
                return false;
            }
            i++;
        }
        
        return true;
    }
    public static void main(String[] args) {
        String s = "rat", t = "car";
        
        System.out.println(are_anagram(s,t));

    }

}
