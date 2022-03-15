package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class MinimumFallingPathSum {

    static int min = Integer.MAX_VALUE;
    static int dp[][] =new int[105][105];
    
    public static boolean isSafe(int n,int row,int col)
    {
        if(row>=n || row<0 || col>=n || col<0)
            return false;
        return true;
    }
    public static void minimumPathHelper(int mat[][],int n,int row,int col,int sum)
    {
        if(isSafe(n,row,col)==false)
        {
            return ;
        }
        
        if(row==n-1)
        {
            sum = sum+mat[row][col];
            min = Math.min(min, sum);
        }
        else
        {
            minimumPathHelper(mat,n,row+1,col,sum+mat[row][col]);
            
            minimumPathHelper(mat,n,row+1,col-1,sum+mat[row][col]);
            
            minimumPathHelper(mat,n,row+1,col+1,sum+mat[row][col]);
            
        }
   
    }
    public static int minimumPath(int mat[][])
    {
        for(int i=0;i<mat.length;i++)
        {
            minimumPathHelper(mat,mat.length,0,i,0);
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
