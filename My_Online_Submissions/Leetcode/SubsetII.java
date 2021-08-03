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
            // Don't use result.add(temp_list)
            // It will take same memory and answer will be 0
            // because of backtracking
            result.add(new ArrayList<Integer>(temp_list));      
            return;
        }
        
        //Exclude && Backtracking
        subset_helper(inp,level+1,n,temp_list,result,true);
        
        // if we had chosen to ignore some element in the decision tree, we should
        // ignore the duplicates in all following decisions for the decision tree. 
        // So we'd return from here, and not process the decision where we include the element. 
        if(level>0 && inp[level]==inp[level-1] && choose_ignore)    return;
        
        //Include
        temp_list.add(inp[level]);
        subset_helper(inp,level+1,n,temp_list,result,false);
        temp_list.remove(temp_list.size()-1);           // Backtrack
        
        
    }
    public static List<List<Integer>> subset(int inp[])
    {
        
        //ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(inp);
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
