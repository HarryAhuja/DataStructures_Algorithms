package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import datastructures.DataStructures_Algorithms.Library_Api.BinarySearch;

public class Search2dMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        
        BinarySearch bs = new BinarySearch();
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for(int r=0;r<rows;r++)
        {
            boolean is_candidate_row = (target>=matrix[r][0]) && (target<=matrix[r][cols-1]);
            
            if(is_candidate_row == true)
            {
                if(bs.search_element(matrix[r], target, 0, cols-1)!=-1)
                    return true;
            }
        }
        
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = {
                            {1,4,7,11,15},
                            {2,5,8,12,19},
                            {3,6,9,16,22},
                            {10,13,14,17,24},
                            {18,21,23,26,30}
                         };
        int target = 5;
        
        System.out.println(searchMatrix(matrix,target));
    }
}
