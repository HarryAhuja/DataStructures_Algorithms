package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Subset {
    
    public static List<List<Integer>> print_all_subsets(int inp[])
    {
        int n = inp.length;
        
        if(n==0)    return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        
        for(int i = 0;i<n;i++)
        {
            int num = inp[i];
            
            int size_list = result.size();
            
            for(int j=0;j<size_list;j++)
            {
                List<Integer> l = new ArrayList<>(result.get(j));
                l.add(num);
                result.add(l);
            }
        }

        return result;
    }
    public static void main(String[] args) {

        int inp[] = {1,2,3};
        
        List<List<Integer>> result = print_all_subsets(inp);
        
        System.out.println(result);

    }

}
