/*
 * Suppose first element of row is greater than last element of previous row
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;

public class Search2dMatrix {
    
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B)
    {
        int n    = A.size();
        int m    = A.get(0).size();
        int low  = 0;
        int high = (n*m)-1;
        
        while(low<=high)
        {
            int mid  = low+(high-low)/2;
            
            if(B==A.get(mid/m).get(mid%m))
            {
                return 1;
            }
            else if(B>A.get(mid/m).get(mid%m))
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return 0;
    }
    
}
