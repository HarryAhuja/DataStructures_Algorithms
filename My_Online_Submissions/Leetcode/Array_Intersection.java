package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.*;

public class Array_Intersection {
	
	static int[] printIntersection(int num1[],int num2[])
	{
		int n1 = num1.length;
		int n2 = num2.length;
		HashMap<Integer,Integer> hash_map = new HashMap<Integer,Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i=0;i<n1;i++)
		{
			/* Alternative method
			 * 
			 * for (i = 0; i < nums1.length; i++)
             *		hash_map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
             *		
             * if key is found then value corresponding to key + 1
             * if key is not found then default value(0)+1
			 */
			if(hash_map.containsKey(num1[i]))
			{
				hash_map.put( num1[i] , hash_map.get(num1[i]) + 1);
			}
			else
			{
				hash_map.put(num1[i],1);
			}
		}
		
		for(int j=0;j<n2;j++)
		{
			if(hash_map.containsKey(num2[j]) == true)
			{
				int freq = hash_map.get(num2[j]);
				if(freq>0)
				{
					result.add(num2[j]);
					hash_map.put(num2[j], freq-1);
				}
			}
		}

		// Option1
		// Java8 direct method, this method is very costly(increased 4ms to 90ms)
		// return result.stream().mapToInt(Integer::intValue).toArray(); 
		
		
		// Option2
		// return Arrays.copyOfRange(nums1, 0, total_result_elements);
		 
		//Option3 : ArrayList to int arr conversion
		int result_array[] = new int[result.size()];
		for(int i=0;i<result.size();i++)
		{
			result_array[i] = result.get(i);
		}
		
		return result_array;
		
	}

	public static void main(String[] args) {
		
		int num1[]= new int[] {1,2,2,1};
		int num2[]= new int[] {2,2};
		
		int result[]=printIntersection(num1,num2);
		
		for(int i=0;i<result.length;i++)
		{
			System.out.print(result[i]+" ");
		}

	}

}
