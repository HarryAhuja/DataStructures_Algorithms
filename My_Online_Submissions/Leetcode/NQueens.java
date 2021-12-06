package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static boolean is_safe(int r,int c,int n,boolean visited[][])
    {
        if(r>=n || r<0 || c>=n || c>=n || visited[r][c]==true)   return false;
        
        int i,j;
        
        // Check same cols of above rows
        i=r-1;
        while(i>=0)
        {
            if(visited[i][c]==true) return false;
            i--;
        }
        
        // Check right above diagonal
        i =r-1;
        j = c+1; 
        while(i>=0 && j<n)
        {
            if(visited[i][j]==true) return false;
            i--;
            j++;
        }
        
        // Check left above diagonal
        i =r-1;
        j = c-1; 
        while(i>=0 && j>=0)
        {
            if(visited[i][j]==true) return false;
            i--;
            j--;
        }
        
        return true;
    }
    public static void solveNQueensHelper(int r,int n,List<List<String>> result,
                                          boolean visited[][])
    {
        if(r==n)
        {
            ArrayList<String> list = new ArrayList<>();
            // at this point of time all visited will be filled
            for(int i=0;i<n;i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    if(visited[i][j]==true) sb.append("Q");
                    else                    sb.append(".");
                }
                list.add(new String(sb));
            }
            result.add(list);
            return ;
        }
        
        
        // iterate over each col
        for(int j=0;j<n;j++)
        {
            if(is_safe(r,j,n,visited)==true)
            {
                visited[r][j] = true;
                
                solveNQueensHelper(r+1,n,result,visited);
                
                visited[r][j] = false;
            }
            
        }
    }
    public static List<List<String>> solveNQueens(int n)
    {
        List<List<String>> result = new ArrayList<>();
        boolean visited[][] = new boolean[n][n];
        
        // pass row number
        solveNQueensHelper(0,n,result,visited);
        
        return result;
    }
    public static void main(String[] args)
    {
        int n = 4;
        List<List<String>> list = solveNQueens(n);
        System.out.println(list);
    }

}
