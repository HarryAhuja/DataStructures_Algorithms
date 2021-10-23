/*
 * |---------------n------------------|
 * 
 * 
 * |------------x------------|----k---|
 * 
 * x+k = n
 * or
 * k+x = n
 * 
 * If i reverse a linked list
 * and move k steps forward
 * 
 * 1.) visualise fast pointer in reverse list and slow pointer
 *     in original linked list
 * 2.) when fast moves x steps forward from k to reach end
 *     slow moves same x step forward in original list to
 *     reach target node
 * 
 * |-----k----|------------x----------|
 * 
 * Aim is to move k steps from backward
 * 
 * Corner cases
 * 1.) k>n
 * 2.) target is head node
 * 3.) target node is second node
 * 4.) target node is last node
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.LinkedList;

public class NthFromLast {
    
    // 1->2->3->4->5
    
    public LinkedListNode removeNthFromEnd(LinkedListNode head, int k) {
        
        if(head == null)    return head;
        
        LinkedListNode fast = head;
        
        for(int i=1;i<=k;i++)
        {
            // if k>n
            if(fast == null)    return head;
            
            // This should be after check not before
            // If head node to be deleted then fast will become null at last
            // Returning head will be wrong bcs head has to be deleted
            fast = fast.next;
        }
       
        if(fast == null)
        {
            // Head has to be deleted
            return head.next;
        }
        
        // fast points to 3
        LinkedListNode slow = head, prev = null;
        
        while(fast!=null)
        {
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }
        // slow points to target node
        prev.next = slow.next;
        
        return head;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
