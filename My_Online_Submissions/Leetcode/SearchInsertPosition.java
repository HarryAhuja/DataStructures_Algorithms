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

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class SearchInsertPosition {
		
	static int searchInsert(int[] inp, int target) {
		
		for(int i=0;i<inp.length;i++)
		{
			if(target<=inp[i])	return i;
		}
		return inp.length;
    }

	public static void main(String[] args) {
		
		int inp[] = new int[] {1,3,5,6};
		int target  = 2;
		
		System.out.println(searchInsert(inp,target));
	}

}
