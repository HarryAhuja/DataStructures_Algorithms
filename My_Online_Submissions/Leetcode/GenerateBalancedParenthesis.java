package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateBalancedParenthesis {

    public static void generate_balanced_parenthesis_helper(int open,int close,String out,List<String> list)
    {
        if(open == 0 && close == 0)
        {
            list.add(out);
            return;
        }
        
        // Use open bracket
        if(open>0)
            generate_balanced_parenthesis_helper(open-1,close,out+"(",list);
        
        // Use close bracket
        // Can't use closing at starting of string
        // Cant' use closing if there is no extra open bracket in parent
        // equality denotes parent is balanced parenthesis
        if(out.equals("") || close<=open || close<=0)    return;
        
        generate_balanced_parenthesis_helper(open,close-1,out+")",list);
    }
    
    public static List<String> generate_balanced_parenthesis(int n)
    {
        List<String> result = new ArrayList<>();
        generate_balanced_parenthesis_helper(n,n,"",result);
        
        return result;
    }
    public static void main(String[] args) {
        int n = 3;
        
        generate_balanced_parenthesis(n);

    }

}
