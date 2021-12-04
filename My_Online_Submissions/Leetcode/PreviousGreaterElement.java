/*
 * Variation of stock span problem
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Stack;

public class PreviousGreaterElement {

    static void prevGreater(int arr[],int n)
    {
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr[0]);
        
        // Previous greater for
        // first element is always -1.
        System.out.print("-1, ");
        
        for(int i=1;i<n;i++)
        {
            while(stack.isEmpty()==false && stack.peek()<=arr[i])
            {
                stack.pop();
            }
            if(stack.isEmpty()==false)
                System.out.print(stack.peek()+" ");
            else
                System.out.print("-1, ");
            
            stack.push(arr[i]);
        }
    }
    public static void main(String[] args)
    {
        int arr[] = { 10, 4, 2, 20, 40, 12, 30 };
        int n = arr.length;
        prevGreater(arr, n);

    }

}
