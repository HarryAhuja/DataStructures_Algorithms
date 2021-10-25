package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class InfixPostfix {
    public static boolean is_operator(char c)
    {
        if(c=='+' || c=='-' || c=='/'|| c=='*')
        {
            return true;
        }
        return false;
    }
    public static boolean is_digit(char c)
    {
        if(c>=48 && c<=57)  return true;
        
        return false;
    }
    public static int precedence(char operator)
    {
        switch(operator)
        {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            default:
                return 2;
        }
    }
    public static int operation(int v1,int v2,char operator)
    {
        switch(operator)
        {
            case '+':
                return v1+v2;
            case '-':
                return v1-v2;
            case '*':
                return v1*v2;
            case '/':
                return v1/v2;
            default:
                return -1;
        }
    }
    public static int calculate(String s) {
        
        Stack<Character> operator = new Stack<>();
        Stack<Integer>   operands = new Stack<>();
        
        int num = 0;
        char c;
        
        for(int i=0;i<s.length();i++)
        {
            c = s.charAt(i);
            
            // digit, operator, space,
            if(is_digit(c)==true)
            {
                num = num*10+(c-'0');
            }
            else if(is_operator(c)==true)
            {
                operands.push(num);
                // c is asking higher precedence to process first
                while(operator.isEmpty()==false && precedence(operator.peek())>=
                                                   precedence(c))
                {
                    Integer v2 = operands.pop();    // v2 was pushed after
                    Integer v1 = operands.pop();
                    operands.push(operation(v1,v2,c));
                }
                
                // c is pushing itself
                operator.push(c);
                
                num = 0;
            }
            else if()
            {
                //skip that char
                // don't make num=0 here, bcs it can be case that bw
                // operator and num there is space. So num will become zero
                //num = 0;
            }
        }
        
        // if operand stack is not empty that means still operations have to be done
        while(operator.isEmpty()==false)
        {
            c          = operator.pop();
            Integer v2 = operands.pop();    // v2 was pushed after
            Integer v1 = operands.pop();
            operands.push(operation(v1,v2,c));
        }
        
        // last element would be answer
        return operands.pop();
    }
    public static void main(String[] args) {
        String s =" 3+51 / 2 ";
        System.out.println(calculate(s));

    }

}
