package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {


    public static void generate_permutation_helper(int inp[], int level,int n,List<Integer> list,
                                                   List<List<Integer>> result,boolean visited[])
    {
        if(level == n)
        {
            result.add(new ArrayList<>(list));
        }
        
        // At each level, all numbers can come
        // except which is used before
        for(int i = 0;i<n;i++)
        {
            if(visited[i] == false)
            {
                visited[i] = true;
                list.add(inp[i]);
                
                generate_permutation_helper(inp,level+1,n,list,result,visited);
                
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
    public static List<List<Integer>> generate_permutation(int inp[])
    {
        int n = inp.length;
        if(n==0)    return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        boolean visited[] = new boolean[n];
        
        generate_permutation_helper(inp,0,n,new ArrayList<>(),result,visited);
        
        return result;
    }
    public static void main(String[] args) {
        int inp[] = {1,2,3};
        
        List<List<Integer>> result = generate_permutation(inp);

        System.out.println(result);
    }

}
