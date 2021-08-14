package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static List<List<Integer>> result = new ArrayList<>();
    
    public static void print_all_subsets_helper(int inp[],int level,int n,ArrayList<Integer> list)
    {
        if(level == n)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        
        // Exclude
        print_all_subsets_helper(inp,level+1,n,list);
        
        // Include
        list.add(inp[level]);
        print_all_subsets_helper(inp,level+1,n,list);
        
        list.remove(list.size()-1);     // Backtrack
    }
    public static List<List<Integer>> print_all_subsets(int inp[])
    {
        int n = inp.length;
        
        if(n==0)    return new ArrayList<>();
        
        print_all_subsets_helper(inp,0,n,new ArrayList<>());
        
        return result;
    }
    public static void main(String[] args) {

        int inp[] = {4,3,2,1};
        
        List<List<Integer>> result = print_all_subsets(inp);

    }

}
