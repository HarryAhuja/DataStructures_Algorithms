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
        
        if(n==0 && m==0)    return 0;           // corner TC
        
        int low  = 0;
        int high = n-1;
        int row  = -1;
        
        // Find upper bound of row
        while(low<=high)
        {
            int mid  = low+(high-low)/2;
            
            if(B==A.get(mid).get(0))
            {
                return 1;
            }
            else if(B>A.get(mid).get(0))
            {
                row = mid;
                low = mid+1;
                
            }
            else
            {
                high = mid-1;
            }
        }
        
        if(row==-1) return 0;   // no row       // corner TC
        
        // finding element in that particular row
        low  = 0;
        high = m-1;
        while(low<=high)
        {
            int mid  = low+(high-low)/2;
            
            if(B==A.get(row).get(mid))
            {
                return 1;
            }
            else if(B>A.get(row).get(mid))
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
