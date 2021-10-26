/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
 * 
 * How swapping is done
 * 
 * See notebook
 * 
*/
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class RotateImage {

    public static void print_matrix(int [][]matrix,int r,int c)
    {
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void swap(int [][]matrix,int r1,int c1, int r2,int c2)
    {
        int temp     = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
    public static void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Turn upside down
        
        // for each col
        for(int j=0;j<cols;j++)
        {
            int i = 0;
            int k = rows-1;
            
            while(i<k)
            {
                swap(matrix,i,j,k,j);
                i++;
                k--;
            }
        }
        
        //print_matrix(matrix,rows,cols);
        
        // Swap symmetrically
        for(int i=0;i<rows;i++)
        {
            // here rows==cols(n*n), so run to either cols or rows
            // But in m*n matters, one will end before
            for(int j=i+1;j<cols;j++)
            {
                swap(matrix,i,j,j,i);
            }
        }
        print_matrix(matrix,rows,cols);
    }
    public static void main(String[] args) {
        int mat[][]= {{1,2,3},{4,5,6},{7,8,9}};
        rotate(mat);

    }

}
