package datastructures.DataStructures_Algorithms.Library_Api;

public class First_Last_Position {
	
	static public int searchRangeFirstIndex(int[] inp, int target,int low,int high)
	{
        int result_index = -1; 
		while(low<=high)
		{
			int mid = low + (high-low)/2;
			
			if(inp[mid] == target)
			{
				result_index = mid;
				high		 = mid-1;
			}
			else if(inp[mid] < target)
			{
				low = mid+1;
			}
			else
			{
				high = mid-1;
			}
		}
		return result_index;
		
    }
	
	static public int searchRangeLastIndex(int[] inp, int target,int low,int high)
	{
		int result_index = -1; 
		while(low<=high)
		{
			int mid = low + (high-low)/2;
			
			if(inp[mid] == target)
			{
				result_index = mid;
				low		     = mid+1;
			}
			else if(inp[mid] < target)
			{
				low = mid+1;
			}
			else
			{
				high = mid-1;
			}
		}
		return result_index;
		
    }
	
	static public int[] searchRange(int[] nums, int target) {
		int result[] = new int[2];
		result[0] = searchRangeFirstIndex(nums, target,0,nums.length-1);
		result[1] = searchRangeLastIndex(nums, target,0,nums.length-1);

		return result;
    }

	public static void main(String[] args) {
		
		int inp[]  = new int[] {5,7,7,8,8,10};
		int target   = 8;
		
		int result[] = searchRange(inp,target);
		
		System.out.println(result[0]+" "+result[1]);

	}

}
