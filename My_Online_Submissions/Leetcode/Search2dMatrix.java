/*
 *  Time complexity = O(m+n)
 *  iterate one row and one col competely
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import datastructures.DataStructures_Algorithms.Library_Api.BinarySearch;

public class Search2dMatrix {
    
    public static boolean searchMatrix(int[][] matrix, int target)
    {
        
        int i = matrix.length-1;
        int j = 0;
        
        while(i>=0 && j<matrix[0].length)
        {
            if(target==matrix[i][j])
            {
                return true;
            }
            else if(target>matrix[i][j])
            {
                j++;
            }
            else
            {
                i--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = {
                            {1},
                            {3},
                            {5}
                         };
        int target = 1;
        
        System.out.println(searchMatrix(matrix,target));
    }
}
