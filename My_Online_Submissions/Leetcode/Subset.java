package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Subset {
    
    public static List<List<Integer>> print_all_subsets(int inp[])
    {
        int n = inp.length;
        
        if(n==0)    return new ArrayList<>();
        
        int p = (1<<n);
        List<List<Integer>> result = new ArrayList<>(p);
        
        for(int i = 0;i<p;i++)
        {
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                if(((i>>j)&0x1)==1)   l.add(inp[j]);
            }
            result.add(l);
        }

        return result;
    }
    public static void main(String[] args) {

        int inp[] = {1,2,3};
        
        List<List<Integer>> result = print_all_subsets(inp);
        
        System.out.println(result);

    }

}
