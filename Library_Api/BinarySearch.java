package datastructures.DataStructures_Algorithms.Library_Api;

public class BinarySearch {

	public int searchFirstIndex(int[] inp, int target,int low,int high, int last_seen)
	{
        if(low<=high)
        {
        	int mid = low + (high-low)/2;
			
			if(inp[mid] == target)
			{
				last_seen  = mid;
				return searchFirstIndex(inp, target,low,mid-1,last_seen);
			}
			else if(inp[mid] < target)
			{
				return searchFirstIndex(inp, target,mid+1,high,last_seen);
			}
			else
			{
				return searchFirstIndex(inp, target,low,mid-1,last_seen);
			}
        }
        
        return last_seen;
    }
	
	public int searchLastIndex(int[] inp, int target,int low,int high,int last_seen)
	{
		if(low<=high)
        {
        	int mid = low + (high-low)/2;
			
			if(inp[mid] == target)
			{
				last_seen  = mid;
				return searchLastIndex(inp, target,mid+1,high,last_seen);
			}
			else if(inp[mid] < target)
			{
				return searchLastIndex(inp, target,mid+1,high,last_seen);
			}
			else
			{
				return searchLastIndex(inp, target,low,mid-1,last_seen);
			}
        }
		
		return last_seen;
    }
}
