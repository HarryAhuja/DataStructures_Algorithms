/*
 *   In this question k can be greater than n
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class RotateRightLL
{
    public LinkedListNode rotateRight(LinkedListNode head, int k)
    {
        if(head == null)    return head;
        
        int count = 1;  // since fast.next is checked not fast!=null
        
        LinkedListNode fast = head;
        
        // Create cycle first
        while(fast.next!=null)
        {
            count++;
            fast =fast.next;
        }
        
        
        // Last node attached to head
        fast.next = head;
        
        // k can be >n but after that same sequence will be generated
        k = (k%count);
        
        fast = head;
        for(int i=0;i<k;i++)
        {
            // fast can't be null in bewteen bcs of k%count
            fast = fast.next;
        }
       
        // 1 2 3 4 5
           
        LinkedListNode slow = head;
        while(fast.next!=head)
        {
            fast = fast.next;
            slow = slow.next;
        }
        
        // for k = 1, slow now points to 4
        LinkedListNode new_head = slow.next;
        
        slow.next = null; // detach LL
        
        return new_head;    
    }
}
