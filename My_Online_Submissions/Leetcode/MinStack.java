/*
 * Space : O(2N)
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Stack;

class StackPair
{
    int value;
    int min;
    public StackPair() {value=-1;min=Integer.MAX_VALUE;}
    public StackPair(int v,int m) {value=v;min=m;}
}

public class MinStack {
    
    public static Stack<StackPair> stack;
    
    public MinStack()
    {
        stack = new Stack<>();
    }
    
    public static void push(int val)
    {
        if(stack.isEmpty()==true)
        {
            stack.push(new StackPair(val,val));
        }
        else
        {
            int min = stack.peek().min;
            if(val<=min)  stack.push(new StackPair(val,val));
            else            stack.push(new StackPair(val,min));
        }
    }
    
    public static void pop()
    {
        if(stack.isEmpty()!=true)  stack.pop();
    }
    
    public static int top()
    {
        if(stack.isEmpty()!=true)  return stack.peek().value;
        else                        return -1;
    }
    
    public static int getMin()
    {
        if(stack.isEmpty()==true)   return -1;
        else                        return stack.peek().min;
    }
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        push(-2);
        push(0);
        push(-3);
        System.out.println(getMin());
        pop();
        System.out.println(top());
        System.out.println(getMin());

    }

}
