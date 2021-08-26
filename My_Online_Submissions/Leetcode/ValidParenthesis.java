package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class ValidParenthesis {
   
    public static boolean is_valid(String inp)
    {
        
        int n = inp.length();
        
        if(n==0)    return false;
        
        Deque<Character> p = new ArrayDeque<>(n);
        
        for(int i=0;i<n;i++)
        {
            char c = inp.charAt(i);
            
            switch(c)
            {
                case '(': p.push(')'); break;
                case '{': p.push('}'); break;
                case '[': p.push(']'); break;
                default : if (p.isEmpty() || p.pop() != inp.charAt(i)) return false;
            }
            
        }
        
        return p.isEmpty();
    }
    public static void main(String[] args) {
        //String inp = "{}}";
        //String inp = "{}{";
        //String inp = "{";
        String inp = "}";
        
        System.out.println(is_valid(inp));
        
        
    }

}
