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
		
		return result.stream().mapToInt(Integer::intValue).toArray();
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
