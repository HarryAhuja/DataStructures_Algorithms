package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class NumberOfIslands {
    
    public static void numIslandsHelper(char[][] grid,int i, int j,int n,int m, boolean visited[][])
    {
        if(i>=n || i<0 || j>=m || j<0 || grid[i][j]=='0' || visited[i][j]==true)
            return;
        
        visited[i][j] = true;
        
        numIslandsHelper(grid, i, j+1, n, m, visited);
        numIslandsHelper(grid, i+1,j, n, m, visited);
        numIslandsHelper(grid, i, j-1, n, m, visited);
        numIslandsHelper(grid, i-1, j, n, m, visited);
    }
    public static int numIslands(char[][] grid)
    {
        int result = 0;
        int n = grid.length;
        int m = grid[0].length;
        
        boolean visited[][] = new boolean [grid.length][grid[0].length];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' && visited[i][j]==false)
                {
                    result++;
                    
                    numIslandsHelper(grid,i,j,n,m,visited);
                }
            }
        }
            
        
        return result;
    }
    public static void main(String[] args) {
        
        char grid[][] = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
                 };
        
        System.out.println(numIslands(grid));

    }

}
