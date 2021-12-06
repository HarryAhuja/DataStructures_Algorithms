/*
 * 
 * total there are 16 cells and 4 queens.
 * Total 16C4 combinations can be there
 * but to reduce these we have imposed three conditions(Bounding function)
 * Q1 can go into row1 only
 * Q2 can go into row2 only and so on
 * 
 * No queen can be in same coloumn
 * No queen can be in same diagonal
 * 
 * 2nd set of solution will be mirror image of first one
 * 
 * Currently is safe function is taking O(n) time
 * We have to improve to O(1)
 * 
 * For same col checking
 * I will maintain bool array of cols which will tell if in any row, jth col
 * is filled or not
 * while checking c, we don't care in which row that cols is filled with col
 * so we don;t need to maintain [r] rows for that col. Just maintain one 
 * variable flag for that cols
 * 
 * Therefore n flags for n cols
 * 
 * For diogaonsl, there are two type of diagonals
 * 
 * Left above and Right above
 * 
 * Properties of these
 * 1.) Left above-> difference of x and y coordinate is constant on same diagonal
 * 2.) Right above-> sum of x and y is constant
 * 
 * So main two bool arrays d1 and d2 where index represent x-y in d1 and x+y in d2
 * 
 * x-y can be negative also
 * max negative value(or min value) can be 0-(n-1)=-(n-1)
 * 
 * so i need array which have indices from -4 to 4
 * 
 * make array of size 2*(n-1)+1
 * 
 * to shift negative to positive
 * 
 * -4   -3  -2  -1  0   1   2   3   4
 * 0    1   2   3   4   5   6   7   8(right shifted by +4)
 * 
 * store i,j at i-j+(n-1) -> shifting by n-1
 * 
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    static boolean col_db[] = new boolean[10];   // n can be from 1 to 9
    static boolean d1_db[]  = new boolean[20];   // 2(n-1)
    static boolean d2_db[]  = new boolean[20];   // 2(n-1)
    
    public static boolean is_safe(int r,int c,int n,boolean visited[][])
    {
        if(r>=n || r<0 || c>=n || c>=n || visited[r][c]==true)   return false;
        
        if(col_db[c]==true || d1_db[r-c+n-1]==true || d2_db[r+c]==true) return false;
        
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
                visited[r][j]    = true;
                col_db[j]        = true;
                d1_db[r-j+(n-1)] = true;
                d2_db[r+j]       = true;
                
                solveNQueensHelper(r+1,n,result,visited);
                
                visited[r][j]    = false;
                col_db[j]        = false;
                d1_db[r-j+(n-1)] = false;
                d2_db[r+j]       = false;
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
