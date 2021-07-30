package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import datastructures.DataStructures_Algorithms.Library_Api.BinarySearch;

public class Search2dMatrix {
    
    public static int find_lower_bound(int[][] matrix, int target, int low, int high)
    {
        int result = -1;
        int cols   = matrix[0].length;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            if(target>matrix[mid][cols-1])
            {
                low = mid+1;
            }
            else if(target<matrix[mid][cols-1])
            {
                result = mid;
                high   = mid-1;
            }
            else
            {
                result = mid;
                break;
            }
        }
        
        return result;
    }
    
    public static int find_upper_bound(int[][] matrix, int target, int low, int high)
    {
        int result = -1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(target>matrix[mid][0])
            {
                result = mid;
                low    = mid+1;
            }
            else if(target<matrix[mid][0])
            {
                high   = mid-1;
            }
            else
            {
                result = mid;
                break;
            }
        }
        
        return result;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        
        BinarySearch bs = new BinarySearch();
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int start_row = 0;
        int end_row   = rows-1;
        
        start_row = find_lower_bound(matrix,target,0,rows-1);
        end_row   = find_upper_bound(matrix,target,0,rows-1);
        
        System.out.println(start_row+" "+end_row);
        
        if((start_row == -1) || (end_row ==-1)) return false;
        
        for(int r=start_row;r<=end_row;r++)
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
                            {1},
                            {3},
                            {5}
                         };
        int target = 1;
        
        System.out.println(searchMatrix(matrix,target));
    }
}
