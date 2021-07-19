package datastructures;

import java.util.*;

public class Array_Intersection {
	
	static int[] printIntersection(int num1[],int num2[])
	{
		
		int n1= num1.length;
		int n2= num2.length;
		ArrayList<Integer> result= new ArrayList<Integer>();
		
		Arrays.sort(num1);
		Arrays.sort(num2);
		
		int i=0,j=0,k=0;
		
		while(i<n1 && j<n2)
		{
			if(num1[i]<num2[j])
			{
				i++;
			}
			else if (num1[i]>num2[j])
			{
				j++;
			}
			else
			{
				result.add(num1[i]);
				i++;
				j++;
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
