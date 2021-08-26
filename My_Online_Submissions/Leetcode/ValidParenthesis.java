package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;

public class ValidParenthesis {
   
    public static boolean is_valid(String inp)
    {
        
        int n = inp.length();
        
        if(n==0)    return false;
        
        char charMap[] = new char[n];
        int  top       = 0;
        
        for(int i=0;i<n;i++)
        {
            char c = inp.charAt(i);
            
            switch(c)
            {
                case '(':
                    charMap[top++] = ')';
                    break;
                case '{':
                    charMap[top++] = '}';
                    break;
                case '[':
                    charMap[top++] = ']';
                    break;
                default:
                    if(c=='}' || c==']' || c==')')
                    {
                        if(top-1<0)             return false;
                        if(c != charMap[top-1]) return false;
                        top--;
                    }
                    else    return false;
                    break;
            }
            
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
