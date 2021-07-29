package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class KClosestElements {
    
    static int search_greater_equal_element_index(int[] inp, int target, int low, int high)
    {
        // Base Cases, if not there then runtime exception in case target>inp[high]
        // it was returning -1
        
        if(target<= inp[0])     return 0;
        if(target>=inp[high])   return high;
        
        
        int result = -1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            
            if(target<inp[mid])
            {
                result = mid;
                high   = mid-1;
            }
            else if(target>inp[mid])
            {
                low = mid+1;
            }
            else
            {
                result = mid;
                break;
            }
            
        }
        
        return result;
    }

	public static List<Integer> findClosestElements(int inp[], int k, int x)
	{
		List<Integer> result = new ArrayList<Integer>();
	
		int n = inp.length;
		
		int index = search_greater_equal_element_index(inp, x, 0, n-1);
		System.out.println(index);

		int count = 0;
		int i 	  = index-1;
		int j     = index;
		
		while(i>=0 && j<n && count<k)
		{ 
		    // Here x should be there, not inp[index] element might not be present
		    
			int left_abs_diff = Math.abs(inp[i]-x);          
			int right_abs_diff = Math.abs(inp[j]-x);         
			
			if(left_abs_diff<=right_abs_diff)
			{
				result.add(inp[i]);
				i--;
			}
			else if(left_abs_diff>right_abs_diff)
			{
				result.add(inp[j]);
				j++;
			}
			count++;
		}
		
		while(i>=0 && count<k)
		{
		    result.add(inp[i]);
		    i--;
		    count++;
		}
		
		while(j<n && count<k)
        {
            result.add(inp[j]);
            j++;
            count++;
            
        }
		
		return result;
	}
	public static void main(String[] args) {
		
		//int arr[] ={1,2,3,4,5};
		//int k = 4, x = -1;
	    
	    //int arr[] = {0,1,1,1,2,3,6,7,8,9};
	    //int k = 9, x = 4;
	    
	    int arr[] = {3,5,8,10};
	    int k =2, x=15;

		List<Integer> result = findClosestElements(arr,k,x);
		result.sort(null);
		
		
		ListIterator<Integer> iter = result.listIterator();
		
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}

}
