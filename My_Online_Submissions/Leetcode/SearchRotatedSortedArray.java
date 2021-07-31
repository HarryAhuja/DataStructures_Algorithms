/*
 * Find index of smallest number(pivot)
 * Find target side
 * Run normal Binary Search
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import datastructures.DataStructures_Algorithms.Library_Api.BinarySearch;

public class SearchRotatedSortedArray {
    
    public static int find_pivot_element(int inp[], int low,int high)
    {
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            if((mid-1)>=low && (mid+1)<=high && 
               inp[mid]<inp[mid-1] && inp[mid]<inp[mid+1])
            {
                return mid;
              
            }
            else if(inp[mid]>inp[high])
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }   
        }
        return low;
    }
    
    public static int find_index_rotated_array(int inp[], int target)
    {
        BinarySearch bs = new BinarySearch();
        
        int n = inp.length;
         
        if(n==0)    return -1;
        if(n==1)    return (inp[0]==target)?0:-1;
        
        int smallest_pivot_element = find_pivot_element(inp,0,n-1);
       
        System.out.println(smallest_pivot_element);
        
        if(smallest_pivot_element>0 && target>=inp[0] && target<=inp[smallest_pivot_element-1])
            return bs.search_element(inp, target, 0, smallest_pivot_element-1);
        else
            return bs.search_element(inp, target, smallest_pivot_element, n-1);
    }

    public static void main(String[] args) {
        
        int inp[] = {3,1};
        int tar   = 3;
        
        System.out.println(find_index_rotated_array(inp,tar));

    }

}
