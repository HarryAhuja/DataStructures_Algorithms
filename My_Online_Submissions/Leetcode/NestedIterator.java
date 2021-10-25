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

public class NestedIterator
{
    List<Integer> flatten = null;
    int current;
    public NestedIterator(List<NestedInteger> nested_list)
    {
        current = 0;
        flatten = new ArrayList<Integer>();
        
        for(int i=0;i<nested_list.size();i++)
        {
            helper(nested_list.get(i));
        }
        
    }
    
    public Integer next()
    {
        return flatten.get(current++);
    }
    
    public boolean hasNext()
    {
        return current<flatten.size();
    }
    private void helper(NestedInteger value)
    {
        // this value can be integer or a list
        // if its a list then getList method fill return the list
        if(value.isInteger()==true) flatten.add(value.getInteger());
        else
        {
            List<NestedInteger> l = value.getList();
            // Iterate over the list and do same thing
            for(int i=0;i<l.size();i++)
            {
                helper(l.get(i));
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
