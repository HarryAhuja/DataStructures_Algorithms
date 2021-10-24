/*
 *  Space  = O(N)
 *  
 *   Proof of modified value<new_minimum
 *   
 *   new value is < prev_minimum, we are pushing 2*new_value-prev_minimum
 *   
 *   We know that at this moment
 *   new_value<prev_minimum
 *   new_value-prev_minimum<0
 *   2*new_value-prev_minimum<new_value
 *   modified_value<new_minimum
 *   
 *   --> Any pop/top gives you value that is less that present_minimum, that
 *   means we have pushed modified value not original value
 *   
 *   How to rollback to prev_minimum if current_minimum is popped
 *   prev_minimum = 2*curr_minimum-stack.pop
 *   
 *   Here stack.pop  = 2*new_val-prev_minimum
 *   and new_value = current_minimum bcs we pushed modified when new_value<prev_minimum
 *   
 *   2*curr_minimum-stack.pop
 *   2*curr_minimum-(2*curr_minimum-prev_minimum)
 *   =prev_minimum
 *   
 *   If we want to check the top
 *   if(top<minimum) that means its a modified value
 *   so top will be minimum bcs we have pushed modified value when its <prev_minimum
 *   so actually new minimum has to be pushed otherwise
 *   
 *   Because we are using 2*val, use long
 *   also range is equal to Integer.max
 *   
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Stack;

public class MinStack {
    
    public static Stack<Long> stack;
    public static Long curr_minimum;
    
    public MinStack()
    {
        curr_minimum    = Integer.MAX_VALUE+1L;
        stack           = new Stack<>();
    }
    
    public static void push(int val)
    {
        if(stack.isEmpty()==true)
        {
            stack.push(val+0L);
            curr_minimum = val+0L;
        }
        else
        {
            if(val<curr_minimum)
            {
                stack.push(2*val-curr_minimum+0L);
                curr_minimum = val+0L;
            }
            else    stack.push(val+0L);
        }
    }
    
    public static void pop()
    {
        if(stack.isEmpty()!=true)
        {
            Long top = stack.pop();
            if(top<curr_minimum)
            {
                curr_minimum =(2*curr_minimum)-top;
            }
        }
    }
    
    public static int top()
    {
        if(stack.isEmpty()!=true)
        {
            Long top = stack.peek();
            if(top<curr_minimum)    return curr_minimum.intValue();
            else                    return top.intValue();
        }
        else                        return -1;
    }
    
    public static Long getMin()
    {
        if(stack.isEmpty()==true)   return -1L;
        else                        return curr_minimum;
    }
    public static void main(String[] args)
    {
         
        MinStack stack = new MinStack();
        push(2147483646);
        push(2147483646);
        push(2147483647);
        System.out.println(top());
        pop();
        System.out.println(getMin());
        pop();
        System.out.println(getMin());
        pop();
        push(2147483647);
        System.out.println(top());
        System.out.println(getMin());
        push(-2147483648);
        //
        System.out.println(top());
        System.out.println(getMin());
        pop();
        //
        System.out.println(getMin());
    }

}
