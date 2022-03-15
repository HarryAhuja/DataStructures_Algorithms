package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class MinimumFallingPathSum {

    static int dp[][] =new int[105][105];
    
    public static boolean isSafe(int n,int row,int col)
    {
        if(row>=n || row<0 || col>=n || col<0)
            return false;
        return true;
    }
    public static int minimumPathHelper(int mat[][],int n,int row,int col,int sum,int visited[][])
    {
        if(isSafe(n,row,col)==false)
        {
            return Integer.MAX_VALUE;
        }
        
        if(dp[row][col]!=Integer.MAX_VALUE) return dp[row][col];
        
        if(row==n-1)
        {
            visited[row][col] = 1;
            
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(visited[i][j]+" ");
                }
                System.out.println();
            }
            visited[row][col] = 0;
            System.out.println();
            System.out.println();
            return mat[row][col];
        }
        else
        {
            visited[row][col] = 1;
            
            int a = minimumPathHelper(mat,n,row+1,col,sum+mat[row][col],visited);
            
            int b = minimumPathHelper(mat,n,row+1,col-1,sum+mat[row][col],visited);
            
            int c = minimumPathHelper(mat,n,row+1,col+1,sum+mat[row][col],visited);
            
            dp[row][col] = Math.min(Math.min(a, b),c)+mat[row][col];
            
            visited[row][col] = 0;
            
            return dp[row][col];
            
        }
   
    }
    public static int minimumPath(int mat[][])
    {
        int min = Integer.MAX_VALUE;
        int visited[][] = new int[mat.length][mat.length];
        
        for(int i=0;i<mat.length;i++)
        {
            min = Math.min(min,minimumPathHelper(mat,mat.length,0,i,0,visited));
        }
        return min;
        
    }
    public static void main(String[] args) {
        
        int mat[][] = new int[][]{{2,1,3},{6,5,4},{7,8,9}};
        
        for(int i=0;i<105;i++)
        {
            for(int j=0;j<105;j++)
            {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        System.out.println(minimumPath(mat));

    }

}
