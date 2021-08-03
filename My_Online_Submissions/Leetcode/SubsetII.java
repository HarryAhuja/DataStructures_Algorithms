package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubsetII {
    
    public static void subset_helper(int inp[],int level,int n,ArrayList<Integer> temp_list,
                                     List<List<Integer>> result, boolean choose_ignore)
    {
        if(level == n)
        {
            result.add(temp_list);
            System.out.println(temp_list);
            return;
        }
        
        //Exclude && Backtracking
        subset_helper(inp,level+1,n,temp_list,result,true);
        
        if(level>0 && inp[level]==inp[level-1] && choose_ignore)    return;
        
        //Include
        temp_list.add(inp[level]);
        subset_helper(inp,level+1,n,temp_list,result,false);
        temp_list.remove(temp_list.size()-1);           // Backtrack
        
        
    }
    public static List<List<Integer>> subset(int inp[])
    {
        Arrays.sort(inp);.
        //ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        List<List<Integer>> result = new ArrayList<>();
        //List<List<Integer>> result = new ArrayList<List<Integer>>();

        subset_helper(inp,0,inp.length,new ArrayList<Integer>(),result,true);
        
        return result;
    }
    public static void main(String[] args) {
        
        int inp[] = {1,2,2};
        subset(inp);
    }

}
