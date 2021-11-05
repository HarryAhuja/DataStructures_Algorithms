/*
 *  0 1 2 0
 *  3 4 5 0
 *  1 2 3 2
 *  
 *   0  0  0
 *   0 -1  0  -> when i am at this zero, i need to check all 4 sides
 *   0 -1  0     where ever -1 is there, that means that row/col is not set yet
 *               by some other row/col
 *               
 *   Above approach is wrong bcs
 *   
 *   1 2 3             1 0 3
 *   5 0 7             0 0 7
 *   0 10 11           0 10 11 -> suppose i am at this zero. For above side, there is 
 *                                already zero(by another one) but whole col is not zero
 *                                (it needs to be). So just looking one element above will
 *                                not work. Go full row/col even if above element is 0 already
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class SetMatrixZero {

    public static void setZeroes(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int dummy[][] = new int[n][m];
        
        // Only for 1d array
        // Runtime exception for multidimensional
        //Arrays.fill(dummy, -1);
        
        for(int i=0;i<n;i++)
        { 
            for(int j=0;j<m;j++)
            {
                dummy[i][j] = -1;
            }
        }
        
        for(int i=0;i<n;i++)
        { 
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j] == 0)
                {
                    //right side
                    {
                        for(int k=j;k<m;k++)
                        {
                            dummy[i][k] = 0;
                        }
                    }
                    
                    //left side
                    {
                        for(int k=j;k>=0;k--)
                        {
                            dummy[i][k] = 0;
                        }
                    }
                    
                    //above side
                    {
                        for(int k=i;k>=0;k--)
                        {
                            dummy[k][j] = 0;
                        }
                    }
                    
                    //down side
                    {
                        for(int k=i;k<n;k++)
                        {
                            dummy[k][j] = 0;
                        }
                    }
                    
                }
            }
        }
        
        for(int i=0;i<n;i++)
        { 
            for(int j=0;j<m;j++)
            {
                if(dummy[i][j] == 0)    matrix[i][j] = dummy[i][j];
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
