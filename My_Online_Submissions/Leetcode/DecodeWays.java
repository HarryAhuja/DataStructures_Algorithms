package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashSet;

public class DecodeWays {

    // We need hashset not map since we don't want actuall grouping sequence
    // only count is needed. Also String is used instead of Integer to handle
    // case of 06 differentiating with 6
    static HashSet<String> set = new HashSet<>();
    
    public static void init_map()
    {
        for(int i=1;i<=26;i++)
            set.add(i+"");
    }
    
    public static int num_decodings_helper(String s, int i,int n)
    {
        if(i>=n)    return 0;
        if(i==n-1)  
        {
            if(set.contains(s.charAt(i)+""))    return 1;
            else                                return 0;
        }
        
        int sub_ans_1 = num_decodings_helper(s, i+1, n);
        int sub_ans_2 = num_decodings_helper(s, i+1, n);
        
        return sub_ans_1+sub_ans_2;
        
    }
    
    public static int numDecodings(String s) 
    {
        init_map();
        
        return num_decodings_helper(s,0,s.length());
    }
    public static void main(String[] args) {
        
        System.out.println(numDecodings("12"));

    }

}
