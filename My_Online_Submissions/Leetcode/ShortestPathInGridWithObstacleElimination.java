/*
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 40
 * 1 <= k <= m * n
 * grid[i][j] is either 0 or 1.
 * grid[0][0] == grid[m - 1][n - 1] == 0
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class ShortestPathInGridWithObstacleElimination
{
    int ans = Integer.MAX_VALUE;;
    
    public boolean is_safe(int grid[][],int r,int c,boolean visited[][])
    {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length)
            return false;
        else if(visited[r][c]==true)
            return false;
        return true;
    }
    public void shortest_path_helper(int grid[][],int k,int i,int j, boolean visited[][],int path)
    {
        if((i==grid.length-1) && (j==grid[0].length-1))
        {
            // no need of safety checking. Value will be always 0 as given
            visited[i][j] = true;
            
            ans = Math.min(ans, path);
            
            return;
        }
        
        
        
        if(is_safe(grid,i,j,visited))
        {
            visited[i][j] = true;
            
            if(grid[i][j]==0)
            {
                shortest_path_helper(grid,k,i,j+1,visited,path+1);
                
                shortest_path_helper(grid,k,i+1,j,visited,path+1);
                
                shortest_path_helper(grid,k,i,j-1,visited,path+1);
                
                shortest_path_helper(grid,k,i-1,j,visited,path+1);
            }
            else
            {
                if(k>0) shortest_path_helper(grid,k-1,i,j+1,visited,path+1);
                
                if(k>0) shortest_path_helper(grid,k-1,i+1,j,visited,path+1);
                
                if(k>0) shortest_path_helper(grid,k-1,i,j-1,visited,path+1);
                
                if(k>0) shortest_path_helper(grid,k-1,i-1,j,visited,path+1);
            }
            
            
            visited[i][j] = false;
        }
    }
    public int shortestPath(int[][] grid, int k)
    {
        int n = grid.length;
        int m = grid[0].length;
        
        if(n==0 && m==0)  return -1;
        
        boolean visited[][] = new boolean[n][m];
        
        shortest_path_helper(grid,k,0,0,visited,0);
         
        return (ans==Integer.MAX_VALUE?-1:ans);
    }
}
