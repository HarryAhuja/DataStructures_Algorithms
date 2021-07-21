/*
 * Think of only case where single element is left
 * Lets say, single element left = 3 and index = 1
 * a.) target = 2, Low==High=1. High will be shifted to mid-1 that is 0
 * Since low>high, we return low(1), that means 2 will take place of 3
 * and 3 will be shifted to right
 * 
 * b.) target = 4, Low==High=1. Low will be shifted to mid+1 that is 2
 * Since low>high, we return low(2), that means 4 will take place after 3
 * and 4 will be shifted to right after 3
 * 
 * So in both cases, end the end low is the required ans
 */

/*
 * Instead of adjusting low to mid+1 or high=mid-1
 * we can shift both to mid but in that case recursion condition should be changed
 * 
 * while(low<=high)-> while(low+1<high) -> This will break when 2 elements are left
 * bcs at one element, infinite while loop will run
 * 
 * Based on two elements we can decide, the ans
 * 
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class SearchInsertPosition {
		
	static int searchInsertRecur(int[] inp, int target, int low, int high) {

		if(low+1>=high)
		{
			if (inp[low] == target){
		        return low;
		    }
			
			if (inp[high]==target){
		        return high;
		    }

		    if (inp[high] < target){
		        return high+1;
		    }

		    if (inp[high]>target && target>inp[low]){
		        return low+1;
		    }

		    if (inp[low] > target){
		        return low;
		    }
		}

		int mid = low+(high-low)/2;	// (low+high)/2 Can run into overflow

		if(inp[mid] == target)	return mid;
		if(target< inp[mid])	return searchInsertRecur(inp, target, low, mid);
		else					return searchInsertRecur(inp, target, mid, high);
	}
	
	static int searchInsert(int[] inp, int target) {
		return searchInsertRecur(inp, target, 0, inp.length-1);
    }

	public static void main(String[] args) {
		
		int inp[] 	= new int[] {1,3,5,6};
		int target  = 2;
		
		System.out.println(searchInsert(inp,target));
	}

}
