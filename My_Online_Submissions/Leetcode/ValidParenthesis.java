package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;

public class ValidParenthesis {
    
    static HashMap<Character,Character> map = new HashMap<>();
    
    public static boolean is_valid(String inp)
    {
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        
        int n = inp.length();
        
        if(n==0)    return false;
        
        char charMap[] = new char[n];
        int  top       = 0;
        
        for(int i=0;i<n;i++)
        {
            char c = inp.charAt(i);
            
            if(c=='{' || c=='[' || c=='(')
            {
                charMap[top++] = c;
            }
            else if (c=='}' || c==']' || c==')')
            {
                // Starting is close bracket
                // or there is no open bracket left
                if(top-1<0) return false;
                
                if(c != map.get(charMap[top-1])) return false;
                
                top--;
            }
            else    return false;
        }
        
        return (top!=0)?false:true;
    }
    public static void main(String[] args) {
        //String inp = "{}}";
        //String inp = "{}{";
        //String inp = "{";
        String inp = "}";
        
        System.out.println(is_valid(inp));
        
        
    }

}
