package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PhoneLetters {
    
    public static String num_to_letter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public static void print_all_combinations_helper(String str,int level,int n,StringBuilder out,
                                                     List<String> result)
    {
        if(level == n)
        {
            result.add(new String(out.toString()));
            return;
        }
        // Integer.valueOf applied to
        // char gives ascii
        // string gives value
        String letters = num_to_letter[Integer.valueOf(str.charAt(level)+"")];
        
        for(int l = 0;l<letters.length();l++)
        {
            out.append(letters.charAt(l));
            
            print_all_combinations_helper(str,level+1,n,out,result);
            
            out.deleteCharAt(level);
        }
    }
    public static List<String> print_all_combinations(String str)
    {
        int n = str.length();
        List<String> result = new ArrayList<>();
        StringBuilder out = new StringBuilder();
        
        if(n==0)    return result;
        
        
        print_all_combinations_helper(str,0,n,out,result);
        
        return result;
    }
    public static void main(String[] args) {
        
        String inp = "23";
        
        List<String> result = print_all_combinations(inp);
        
        System.out.println(result);

    }

}
