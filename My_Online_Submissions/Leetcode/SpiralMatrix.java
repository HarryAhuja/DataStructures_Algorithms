/*
 * Test cases
 * single row, single col, two rows, two cols, center element
 * one element being printed twice
 * single horizontal, vertical col
 * 
 * Tricky part, after each direction wheck condition of while loop
 * to prevent duplicate values
 * 
 * Take example of one vertical col
 * Up to down and down to up, we can traverse only once by checking cols
 * which will be checked by while loop
 * 
 * if i check while loop only after 4 directions then it will be duplicated
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        
        List<Integer> list = new ArrayList<Integer>();
        
        int left_col  = 0;
        int right_col = m-1;
        int above_row = 0;
        int below_row = n-1;
        int dir       = 0;
        
        while(above_row<=below_row && left_col<=right_col)
        {   
            switch(dir)
            {
                case 0:
                    // Left to right
                    for(int i=left_col;i<=right_col;i++)
                    {
                        list.add(matrix[above_row][i]);
                        
                    }
                    above_row++;
                break;
                
                case 1:
                    // Up to down
                    for(int i=above_row;i<=below_row;i++)
                    {
                        list.add(matrix[i][right_col]);
                    }
                    right_col--;
                break;
                
                case 2:
                    // Right to left
                    for(int i=right_col;i>=left_col;i--)
                    {
                        list.add(matrix[below_row][i]);
                        
                    }
                    below_row--;
                break;
                
                case 3:
                    
                    // Down to up
                    for(int i=below_row;i>=above_row;i--)
                    {
                        list.add(matrix[i][left_col]);
                       
                    }
                    left_col++;
                break;
            }
            dir =(dir+1)%4;
        }
        
        
        return list;
    }
    public static void main(String[] args) {
        
        int mat[][]= {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(mat));

    }

}
