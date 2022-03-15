package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class MinimumFallingPathSum {

    static int dp[][] =new int[105][105];
    
    public static boolean isSafe(int n,int row,int col)
    {
        if(row>=n || row<0 || col>=n || col<0)
            return false;
        return true;
    }
    public static int minimumPathHelper(int mat[][],int n,int row,int col,int sum)
    {
        if(isSafe(n,row,col)==false)
        {
            return Integer.MAX_VALUE;
        }
        
        if(dp[row][col]!=Integer.MAX_VALUE) return dp[row][col];
        
        if(row==n-1)
        {
            return mat[row][col];
        }
        else
        {
            int a = minimumPathHelper(mat,n,row+1,col,sum+mat[row][col]);
            
            int b = minimumPathHelper(mat,n,row+1,col-1,sum+mat[row][col]);
            
            int c = minimumPathHelper(mat,n,row+1,col+1,sum+mat[row][col]);
            
            dp[row][col] = Math.min(Math.min(a, b),c)+mat[row][col];
            
            return dp[row][col];
            
        }
   
    }
    public static int minimumPath(int mat[][])
    {
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<mat.length;i++)
        {
            min = Math.min(min,minimumPathHelper(mat,mat.length,0,i,0));
        }
        return min;
        
    }
    public static void main(String[] args) {
        
        int mat[][] = new int[][]{{-48}};
        
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
