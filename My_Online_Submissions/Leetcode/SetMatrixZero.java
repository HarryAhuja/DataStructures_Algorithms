/*
    0   1   2   0
    3   4   5   0
    7   8   9   8
    
    We will use first row and col to store if that row/col contains any zero
    then iterate from i+1,j+1 to end by using these storages
    We will not iterate 0th row and col with this iteration bcs if we does
    then storage might be overwritten and will effect others rows and cols
    At the end, we will fix first row and col
    
    Will use 0 as the flag for indication of presence of zero bcs
    we can't use other than integer range bcs it can be genuine value
    0 can be used since it has to be overwritten with 0
    
    Values after 1st iteration
          >   >
      0   1   2   0
      0   4   5   0
     >7   8   9   8
     
     non zero first values say thay don't contain zeroes in col/rows
     
     Now if we iterate from 0th row/col this will get effected
     
     after 2nd iteration
     
     0  1   2   0
     0  0   0   0
     0  8   9   0
     
     Now fix 0th row/col
     
     0  0   0   0
     0  0   0   0
     0  8   9   0
     
     2nd example
     1  2   3   7
     2  0   7   8
     0  1   2   3
     1  2   3   0
     
     First 3 should remain 3. While fixing 0th row/col, [0][0] is confused whether
     its 0 means first row should be whole zeroes or first col
     So keep separate flags for them
    
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class SetMatrixZero {

    public static void print_mat(int mat[][],int r,int c)
    {
        for(int i=0;i<r;i++)
        { 
            for(int j=0;j<c;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void setZeroes(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean first_row = false;
        boolean first_col = false;
        
        // first row
        for(int k=0;k<m;k++)
        { 
            if(matrix[0][k] == 0)
            {
                first_row = true;
                break;
            }
            
        }
        //First col
        for(int k=0;k<n;k++)
        { 
            if(matrix[k][0] == 0)
            {
                first_col = true;
            }
            
        }
        
        // check from onwards
        // values of 0th row/col will signify only onwards data
        // bcs for both 0th row/col, we have separate flags
        for(int i=1;i<n;i++)
        { 
            for(int j=1;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        //put zero
        for(int i=1;i<n;i++)
        { 
            for(int j=1;j<m;j++)
            {
                if(matrix[i][0] == 0 ||
                   matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // first row
        for(int k=0;first_row && k<m;k++)
        { 
            matrix[0][k] = 0;
            
        }
        //First col
        for(int k=0;first_col && k<n;k++)
        { 
            matrix[k][0] = 0;
        }
    }
    public static void main(String[] args) {
        int mat[][] = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
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
