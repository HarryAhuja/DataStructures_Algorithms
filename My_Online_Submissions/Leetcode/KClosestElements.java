package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class KClosestElements {
    
	public static List<Integer> findClosestElements(int inp[], int k, int x)
	{
	    int low = 0, high = inp.length-1;
	    
	    while(high-low+1>k)
	    {
	        int diff_low = Math.abs(inp[low]-x);
	        int diff_high = Math.abs(inp[high]-x);
	        
	        if(diff_low<diff_high)
	        {
	            high--;
	        }
	        else if(diff_low>diff_high)
            {
                low++;
            }
	        else
	        {
	            high--;
	        }
	    }
	    
	    List<Integer> result = new ArrayList<Integer>();
	    
	    for(int i=low;i<=high;i++)
	        result.add(inp[i]);
	    
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
			
		ListIterator<Integer> iter = result.listIterator();
		
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}

}
