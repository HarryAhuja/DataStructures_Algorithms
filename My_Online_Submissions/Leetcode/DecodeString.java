package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Stack;

public class DecodeString
{
    // ab[cd]{2}
    // def[ab[cd]{2}]{3}ghi
    public static void decode(String str,int n)
    {
        StringBuilder ans = new StringBuilder();
        Stack<String> stack = new Stack<>();
        
        int i= 0 ;
        while(i<n)
        {
            char c = str.charAt(i);
            
            if(c=='[')
            {
                int temp = i+1;
                i++;
                
                while(i<n && str.charAt(i)!='[' && str.charAt(i)!=']')
                {
                    i++;
                }
                
                stack.push(str.substring(temp,i));
            }
            else if(c=='{')
            {
                int temp = i+1;
                i++;
                
                while(i<n && str.charAt(i)!='}')
                {
                    i++;
                }
                
                String number = str.substring(temp,i);
                int intNumber = Integer.parseInt(number);
                String top = stack.pop();
                
                StringBuilder ss = new StringBuilder();
                while(intNumber-->0)
                {
                    ss.append(top);
                }
                
                if(stack.isEmpty()==false)
                {
                    top = stack.pop();
                    stack.push(top+ss.toString());
                }
                else
                {
                    ans.append(ss);
                }
                
                
            }
            else if(Character.isLetter(c))
            {
                ans.append(c);
                i++;
            }
            else
            {
                i++;
            }
        }
        
        System.out.println(ans);
    }
    public static void main(String a[])
    {
        String str = "def[ab[cd]{2}]{3}ghi";
        
        decode(str,str.length());
    }
}
