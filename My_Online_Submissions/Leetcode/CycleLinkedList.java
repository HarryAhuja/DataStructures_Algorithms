/*
 * Suppose I have a circle of length any
 * Two players started a random positions
 * If one player is moving one step and second two steps
 * Then in the circle, faster player is getting close by one step
 * in each iteration(relative velocity)
 * If two cars moving in same direction, faster car will get close by
 * some units/sec and eventually will meet slower car at some common point
 * (when crosses)
 * 
 * So same concept, once slower enters the cycle, then this concept comes into
 * play
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class CycleLinkedList {
    public boolean hasCycle(LinkedListNode head) {
        
        if(head == null)    return false;
        
        LinkedListNode walker = head, runner = head;
        
        // if no cycle, then this condition will hit
        while(runner!=null && runner.next!=null)
        {
            // First increment before comparing to avoid
            // first head case
            runner = runner.next.next;
            walker = walker.next;
            
            // Comparing address of values are duplicate
            if(runner == walker)    return true;
        }

        return false;
    }
    public static void main(String[] args) {
        

    }

}
