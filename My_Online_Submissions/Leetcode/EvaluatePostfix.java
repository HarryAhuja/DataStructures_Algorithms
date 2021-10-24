package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Stack;

public class EvaluatePostfix {
    
    public static boolean is_operator(String s)
    {
        if(s.equals("+") || s.equals("-") || s.equals("/")|| s.equals("*"))
        {
            return true;
        }
        return false;
    }
    public static int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<tokens.length;i++)
        {
            String s = tokens[i];
            
            if(is_operator(s)==false)
            {
                stack.push(Integer.parseInt(s));
            }
            else
            {
                Integer oper1 = stack.pop();
                Integer oper2 = stack.pop();
                Integer result;
                switch(s)
                {
                case "+":
                    result = oper2+oper1;
                    break;
                case "-":
                    // take care of oper2-oper1
                    result = oper2-oper1;
                    break;
                case "*":
                    result = oper2*oper1;
                    break;
                case "/":
                    result = oper2/oper1;
                    break;
                default:
                    return -1;
                }
                stack.push(result);
            }
        }
        
        if(stack.isEmpty()==true)   return -1;
        else                        return stack.pop();
    }
    public static void main(String[] args) {
        
        String tokens[] = {"4","13","5","/","+"};
        
        System.out.println(evalRPN(tokens));

    }

}
