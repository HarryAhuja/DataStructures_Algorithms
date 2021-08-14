package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    
    
    public static void print_all_subsets_helper(int inp[],int level,int n,
                                                ArrayList<Integer> list,List<List<Integer>> result)
    {
        result.add(new ArrayList<>(list));
        
        for(int i = level;i<n;i++)
        {
            list.add(inp[i]);
            print_all_subsets_helper(inp,i+1,n,list,result);
            list.remove(list.size()-1);
        }
    }
    public static List<List<Integer>> print_all_subsets(int inp[])
    {
        int n = inp.length;
        
        if(n==0)    return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        
        print_all_subsets_helper(inp,0,n,new ArrayList<>(),result);
        
        return result;
    }
    public static void main(String[] args) {

        int inp[] = {4,3,2,1};
        
        List<List<Integer>> result = print_all_subsets(inp);

    }

}
