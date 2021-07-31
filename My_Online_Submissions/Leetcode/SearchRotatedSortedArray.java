/*
 * Single traversal
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;


public class SearchRotatedSortedArray {
    
    public static int find_index_rotated_array_helper(int inp[], int target, int low,int high)
    {
        int result = -1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            if(inp[mid] == target)  return mid;
            
            //Left Half Sorted
            if(inp[mid]>=inp[low])
            {
                if(target>=inp[low] && target<inp[mid]) high = mid-1; // Target lies in left sorted
                else                                    low  = mid+1; // Target lies in right unsorted
            }
            // Right Half Sorted
            else
            {
                if(target>inp[mid] && target<=inp[high]) low  = mid+1; // Target lies in right sorted
                else                                     high = mid-1; // Target lies in left unsorted
            }
        }
        
        return result;
    }
    
    public static int find_index_rotated_array(int inp[], int target)
    {
        int n = inp.length;
         
        if(n==0)    return -1;
        if(n==1)    return (inp[0]==target)?0:-1;
        
        return find_index_rotated_array_helper(inp, target,0,n-1);
    }

    public static void main(String[] args) {
        
        int inp[] = {3,1};
        int tar   = 3;
        
        System.out.println(find_index_rotated_array(inp,tar));

    }

}
