package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void swap(int i,int j, int inp[])
    {
        int temp = inp[i];
        inp[i]   = inp[j];
        inp[j]   = temp;
    }
    public static void generate_permutation_helper(int inp[], int level,int n,List<List<Integer>> result)
    {
        if(level == n)
        {
            ArrayList<Integer> al = new ArrayList<>();
            for(int x = 0;x<n;x++)  al.add(inp[x]);
            
            result.add(al);
        }
        
        for(int i = level;i<n;i++)
        {
            swap(level,i,inp);
            
            generate_permutation_helper(inp,level+1,n,result);
            
            swap(level,i,inp);
        }
    }
    public static List<List<Integer>> generate_permutation(int inp[])
    {
        int n = inp.length;
        if(n==0)    return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        
        generate_permutation_helper(inp,0,n,result);
        
        return result;
    }
    public static void main(String[] args) {
        int inp[] = {1,2,3};
        
        List<List<Integer>> result = generate_permutation(inp);

        System.out.println(result);
    }

}
