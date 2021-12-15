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
    static  int  ans = Integer.MAX_VALUE;;
    
    public static  boolean is_valid_index(int grid[][],int r,int c)
    {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length)
            return false;
        return true;
    }
    
    public static  boolean is_destination(int grid[][],int r,int c)
    {
        if((r==grid.length-1) && (c==grid[0].length-1))   return true;
        else                                        return false;
    }
    
    public static  boolean can_pass(int grid[][],int r,int c,int k)
    {
        if(grid[r][c]==0 || (grid[r][c]==1 && k>0)) return true;
        else                                        return false;
    }
    
    
    public static  void shortest_path_helper(int grid[][],int k,int i,int j, boolean visited[][],int path)
    {
        
        if(is_valid_index(grid,i,j) && (visited[i][j]== false) && can_pass(grid,i,j,k))
        {
            visited[i][j] = true;
            
            if(is_destination(grid, i, j))
            {
                ans = Math.min(ans, path);
            }
            else
            {
                path++;
                
                k = (grid[i][j]==1)?k-1:k;
                
                shortest_path_helper(grid,k,i,j+1,visited,path);
                
                shortest_path_helper(grid,k,i+1,j,visited,path);
                
                shortest_path_helper(grid,k,i,j-1,visited,path);
                
                shortest_path_helper(grid,k,i-1,j,visited,path);
            }
            
            visited[i][j] = false;
        }
    }
    public static int shortestPath(int[][] grid, int k)
    {
        int n = grid.length;
        int m = grid[0].length;
        
        if(n==0 && m==0)  return -1;
        
        boolean visited[][] = new boolean[n][m];
        
        shortest_path_helper(grid,k,0,0,visited,0);
         
        return (ans==Integer.MAX_VALUE?-1:ans);
    }
    
    public static void main(String[] a)
    {
            int mat[][] = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
            int k = 1;
            System.out.println(shortestPath(mat,k));
    }
}
