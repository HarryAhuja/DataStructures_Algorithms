package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class RatInMaze {

    public static boolean is_safe(int M[][],int r,int c,int n,int m,boolean visited[][])
    {
        if(r<0 || c<0 || r>=n || c>=m || visited[r][c]==true || M[r][c]==0)
            return false;
        
        return true;
    }
    public static boolean solve_maze_helper(int M[][],int i,int j,int n,int m,
                                            boolean visited[][])
    {
        if(i==n-1 && j==m-1 && M[i][j]==1)
        {
            // M is checked bcs is safe is not called for this i and j
            // if at last position, path is blocked then sol is not possibles
            visited[i][j] = true;
            return true;
        }
        if(is_safe(M,i,j,n,m,visited))
        {
            visited[i][j] = true;
            
            // forward
            if(solve_maze_helper(M, i, j+1,n,m, visited)==true)
                return true;
            
            //down
            if(solve_maze_helper(M, i+1, j,n,m, visited)==true)
                return true;
            
            visited[i][j] = false;
        }
        
        return false;
    }
    public static boolean solveMaze(int M[][])
    {
        boolean visited[][] = new boolean[M.length][M[0].length];
        
        if(solve_maze_helper(M,0,0,M.length,M[0].length,visited))
        {
            for(int x=0;x<M.length;x++)
            {
                for(int y=0;y<M[0].length;y++)
                {
                    if(visited[x][y]==true) System.out.print("1 ");
                    else                    System.out.print("0 ");
                }
                System.out.println();
            }
            return true;
        }
        
        
        return false;
    }
    public static void main(String[] args) {
        
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };

        solveMaze(maze);

    }

}
