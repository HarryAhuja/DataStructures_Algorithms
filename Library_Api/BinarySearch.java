package datastructures.DataStructures_Algorithms.Library_Api;

public class BinarySearch {

	public int search_first_index(int[] inp, int target,int low,int high, int last_seen)
	{
        if(low<=high)
        {
        	int mid = low + (high-low)/2;
			
			if(inp[mid] == target)
			{
				last_seen  = mid;
				return search_first_index(inp, target,low,mid-1,last_seen);
			}
			else if(inp[mid] < target)
			{
				return search_first_index(inp, target,mid+1,high,last_seen);
			}
			else
			{
				return search_first_index(inp, target,low,mid-1,last_seen);
			}
        }
        
        return last_seen;
    }
	
	public int search_last_index(int[] inp, int target,int low,int high,int last_seen)
	{
		if(low<=high)
        {
        	int mid = low + (high-low)/2;
			
			if(inp[mid] == target)
			{
				last_seen  = mid;
				return search_last_index(inp, target,mid+1,high,last_seen);
			}
			else if(inp[mid] < target)
			{
				return search_last_index(inp, target,mid+1,high,last_seen);
			}
			else
			{
				return search_last_index(inp, target,low,mid-1,last_seen);
			}
        }
		
		return last_seen;
    }
	
	public int search_element(int[] inp, int target,int low,int high)
	{
		if(low<=high)
        {
        	int mid = low + (high-low)/2;
			
			if(inp[mid] == target)
			{
				return mid;
			}
			else if(inp[mid] < target)
			{
				return search_element(inp, target,mid+1,high);
			}
			else
			{
				return search_element(inp, target,low,mid-1);
			}
        }
		
		return -1;
    }
	
	public int search_greater_equal_element_index(int[] inp, int target, int low, int high)
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
}
