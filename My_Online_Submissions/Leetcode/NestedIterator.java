/*
 *  Complex structure can be
 *  
 *  List        ->2   ->List
 *   3                   1
 *   |                 
 *   List->3->4          |
 *   |                   1 
 *   List->1->2
 *   
 *   Output
 *   3->3->4->1->2->2->1->1
 *   
 *   Elements can be list or integer
 *   If integer-> directly flatten it
 *   if list   -> Elements of this list can be integer or list as well
 *   If list   -> then we need to iterate this list again recursively
 *   doing the same thing that we are doing on parent list-> this
 *   means calling method again on this element(list)
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NestedIterator
{
    Stack<NestedInteger> stack = null;
    
    public NestedIterator(List<NestedInteger> nested_list)
    {
        stack   = new Stack<NestedInteger>();
        
        helper(nested_list);
        
        while(stack.isEmpty()==false && (stack.peek().isInteger()==false))
        {
            List<NestedInteger> l = (stack.pop()).getList();
            helper(l);
        }
    }
    
    public Integer next()
    {
        return stack.pop()
    }
    
    public boolean hasNext()
    {
        return current<flatten.size();
    }
    private void helper(List<NestedInteger> nested_list)
    {
        // Put it in reverse order such that first element appears at the top
        // when called next, we can directly return
        for(int i=nested_list.size()-1;i>=0;i--)
        {
            stack.push(nested_list.get(i));
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
