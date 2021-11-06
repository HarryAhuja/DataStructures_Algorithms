/*
    We don't need exact position of zero
    Any cell would be made zero if its row/col contains at least one zero
    
    Store isContains zero for row and col.
    If contains, make right and down as zero
    Any cell in the random position will do right and below only
    bcs above and left would have been taken care while
    reaching there
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class SetMatrixZero {

    public static void setZeroes(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean row[] = new boolean[n];
        boolean col[] = new boolean[m];
        
        
        for(int i=0;i<n;i++)
        { 
            for(int j=0;j<m;j++)
            {
                
            }
        }
        
        for(int i=0;i<n;i++)
        { 
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        for(int i=0;i<n;i++)
        { 
            for(int j=0;j<m;j++)
            {
                if(row[i] == true ||
                   col[j] == true)
                {
                    matrix[i][j] = 0;
                }
   
            }
        }
    }
    public static void main(String[] args) {
        int mat[][] = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(mat);
        
        for(int i=0;i<mat.length;i++)
        { 
            for(int j=0;j<mat[0].length;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

    }

}
