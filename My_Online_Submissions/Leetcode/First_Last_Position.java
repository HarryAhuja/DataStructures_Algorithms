package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class First_Last_Position {
	
	static public int searchRangeFirstIndex(int[] inp, int target,int low,int high, int last_seen)
	{
        if(low<=high)
        {
        	int mid = low + (high-low)/2;
			
			if(inp[mid] == target)
			{
				last_seen  = mid;
				return searchRangeFirstIndex(inp, target,low,mid-1,last_seen);
			}
			else if(inp[mid] < target)
			{
				return searchRangeFirstIndex(inp, target,mid+1,high,last_seen);
			}
			else
			{
				return searchRangeFirstIndex(inp, target,low,mid-1,last_seen);
			}
        }
        
        return last_seen;
    }
	
	static public int searchRangeLastIndex(int[] inp, int target,int low,int high,int last_seen)
	{
		if(low<=high)
        {
        	int mid = low + (high-low)/2;
			
			if(inp[mid] == target)
			{
				last_seen  = mid;
				return searchRangeLastIndex(inp, target,mid+1,high,last_seen);
			}
			else if(inp[mid] < target)
			{
				return searchRangeLastIndex(inp, target,mid+1,high,last_seen);
			}
			else
			{
				return searchRangeLastIndex(inp, target,low,mid-1,last_seen);
			}
        }
		
		return last_seen;
    }
	
	static public int[] searchRange(int[] nums, int target)
	{
		int result[] = new int[2];
		
		result[0] = searchRangeFirstIndex(nums, target,0,nums.length-1, -1);
		result[1] = searchRangeLastIndex(nums, target,0,nums.length-1, -1);
		
		return result;
    }

	public static void main(String[] args) {
		
		int inp[]  = new int[] {5,7,7,8,8,10};
		int target   = 8;
		
		int result[] = searchRange(inp,target);
		
		System.out.println(result[0]+" "+result[1]);

	}

}
