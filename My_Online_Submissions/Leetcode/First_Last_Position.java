package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class First_Last_Position {
	static private int first_index = -1;
	static private int last_index  = -1;
	
	static public void searchRangeFirstIndex(int[] inp, int target,int low,int high)
	{
        if(low<=high)
        {
        	int mid = low + (high-low)/2;
			
			if(inp[mid] == target)
			{
				first_index  = mid;
				searchRangeFirstIndex(inp, target,low,mid-1);
			}
			else if(inp[mid] < target)
			{
				searchRangeFirstIndex(inp, target,mid+1,high);
			}
			else
			{
				searchRangeFirstIndex(inp, target,low,mid-1);
			}
        }
    }
	
	static public void searchRangeLastIndex(int[] inp, int target,int low,int high)
	{
		if(low<=high)
        {
        	int mid = low + (high-low)/2;
			
			if(inp[mid] == target)
			{
				last_index  = mid;
				searchRangeLastIndex(inp, target,mid+1,high);
			}
			else if(inp[mid] < target)
			{
				searchRangeLastIndex(inp, target,mid+1,high);
			}
			else
			{
				searchRangeLastIndex(inp, target,low,mid-1);
			}
        }
		
    }
	
	static public int[] searchRange(int[] nums, int target)
	{
		int result[] = new int[2];
		
		searchRangeFirstIndex(nums, target,0,nums.length-1);
		result[0] = first_index;
		 
		searchRangeLastIndex(nums, target,0,nums.length-1);
		result[1] = last_index;
				

		return result;
    }

	public static void main(String[] args) {
		
		int inp[]  = new int[] {5,7,7,8,8,10};
		int target   = 8;
		
		int result[] = searchRange(inp,target);
		
		System.out.println(result[0]+" "+result[1]);

	}

}
