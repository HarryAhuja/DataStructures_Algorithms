package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class NumberOfIslands {
    
    static final int MARK_T = 0;
    static final int MARK_X = 1;
    
    public static void solveHelper(char[][] grid,int i, int j,int n,int m,int flag)
    {
        if((i>=n) || i<0 || (j>=m) || j<0 || grid[i][j]=='X')
            return;
        
        

        switch(flag)
        {
            case MARK_T:
                // to remove infinte loop while marking T
                if(grid[i][j]=='T') return;
                
                grid[i][j] =  'T';
                break;
            case MARK_X:
                // Same condition of T is applied in base case
                grid[i][j] =  'X';
                break;
        }
        
        
        solveHelper(grid, i, j+1, n, m,flag);
        solveHelper(grid, i+1,j, n, m,flag);
        solveHelper(grid, i, j-1, n, m,flag);
        solveHelper(grid, i-1, j, n, m,flag);
    }
    public static void solve(char[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
       
        // First and Last row cells
        for(int k=0;k<m;k++)
        {
            solveHelper(grid,0,k,n,m,MARK_T);
            solveHelper(grid,n-1,k,n,m,MARK_T);
        }
        
        // First and Last Col cells
        for(int k=0;k<n;k++)
        {
            solveHelper(grid,k,0,n,m,MARK_T);
            solveHelper(grid,k,m-1,n,m,MARK_T);
        }
       
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='O')
                {
                    solveHelper(grid,i,j,n,m,MARK_X);
                }
                else if(grid[i][j]=='T')    grid[i][j] = 'O';
            }
        }
    }
    public static void main(String[] args) {
        
        char grid[][] = {
                {'O','O'},
                {'O','O'}
                 };
        
        solve(grid);
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

}
