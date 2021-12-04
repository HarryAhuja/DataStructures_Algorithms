package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram
{
    // push indices instead of value for width calculation
    
    // store left smaller element
    static Stack<Integer> s1 = new Stack<>();
    // store right smaller element
    static Stack<Integer> s2 = new Stack<>();
    
    
    public static int largestRectangleArea(int[] heights)
    {
        int n = heights.length;
        
        if(n==0)    return 0;
        if(n==1)    return heights[0];
        
        int left_smaller[]  = new int[n];
        int right_smaller[] = new int[n];
        
        s1.push(0);
        left_smaller[0] = -1;
        
        for(int i=1;i<n;i++)
        {
            // use == to remove equal height bar also. Bcs i want to include
            // them in width
            while(s1.isEmpty()==false && heights[s1.peek()]>=heights[i])
            {
                s1.pop();
            }
            
            if(s1.isEmpty()==true)
            {
                left_smaller[i] = 0;
            }
            else
            {
                left_smaller[i] = s1.peek()+1;
            }
            s1.push(i);
        }
        
        
        
        s2.push(n-1);
        right_smaller[n-1] = -1;
        
        for(int i=n-2;i>=0;i--)
        {
            // use == to remove equal height bar also. Bcs i want to include
            // them in width
            while(s2.isEmpty()==false && heights[s2.peek()]>=heights[i])
            {
                s2.pop();
            }
            
            if(s2.isEmpty()==true)
            {
                right_smaller[i] = n;
            }
            else
            {
                right_smaller[i] = s2.peek()+1;
            }
            s2.push(i);
        }
        
        int max = 0;
        for(int i=0;i<n;i++)
        {
            int left  = left_smaller[i];
            int right = right_smaller[i];
            
            if(left!=-1 && right!=-1)
                max = Math.max(max, (right-left+1)*heights[i]);
            
        }
        return max;
    }
    
    public static void main(String[] ar)
    {
        int h[] = {1,1};
        System.out.println(largestRectangleArea(h));
    }
}
