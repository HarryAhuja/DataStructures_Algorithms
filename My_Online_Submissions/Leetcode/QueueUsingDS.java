/*
 * 
 *  4       
 *  3
 *  2
 *  5
 * 
 * s1       s2
 * 
 * push(6)
 * 
 * 4    3   2   5   (6)
 * 
 * 1.) 4 should be on top of stack at last so that pop can happen it at first
 * 2.) x(6) should be at last of stack bcs its last pushed
 * 3.) to do this, first shift all elements of s1 to s2
 * 
 *        5
 *        2
 *        3
 * 6      4
 * s1     s2
 * 
 * 4.) now push x to s1(to meet 2nd point)
 * 5.) now 4 should be on top(first element enqueued) for front operation
 *     move all s2 elements back to s1
 * 
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Stack;

public class QueueUsingDS {

    static Stack<Integer> s1;      // Assume this will contain elements
    static Stack<Integer> s2;      // just dummy stack for shifting
    
    public QueueUsingDS()
    {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    public static boolean isEmpty()
    {
        return s1.isEmpty();
    }
    
    public void enqueue(int x)
    {
        /*
         * s1->s2
         * x->s1
         * s2->s1  
         */
        
        while(s1.isEmpty()==false)
        {
            s2.push(s1.pop());
        }
        s1.push(x);
        
        while(s2.isEmpty()==false)
        {
            s1.push(s2.pop());
        }
    }
    
    public static int deque()
    {
        if(s1.isEmpty())    return -1;
        else                return s1.pop();
    }
    
    public static int front()
    {
        if(s1.isEmpty())    return -1;
        else                return s1.peek();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
