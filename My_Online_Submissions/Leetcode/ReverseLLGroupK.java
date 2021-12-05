package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.LinkedList;

public class ReverseLLGroupK
{
    public static LinkedListNode reverseKGroup(LinkedListNode head, int k)
    {
        if(head == null || head.next==null || k==1) return head;
        
        LinkedListNode temp = head;
        int n = 0;
        while(temp!=null)
        {
            temp=temp.next;
            n++;
        }
 
        LinkedListNode dummy = new LinkedListNode(-1);
        dummy.next = head;
        
        LinkedListNode prev = null, curr = head , next = null;
        LinkedListNode new_head = null, prev_group = null;
        
        boolean flag = false;
        
        // this while loop only runs n/k times
        // inside while loop runs k times each outer loop
        // total TC = n/k*k = O(n)
        while(n>=k)
        {
            int count = 0;
            
            // Reversing  k nodes within group
            while(curr!=null && count<k)
            {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            
            /*
             * 2->1   4->3->5
             * we have to connect 1(last node after reversal of previous group)
             * to 4(prev in current iteration)
             * then update prev_group to last_node of current group(3) (head) 
             */
            if(prev_group!=null)
                prev_group.next = prev;
            prev_group = head;
            
            // Connect 3 to 5(don't split LL after reversing current group)
            head.next = curr;
            // Move head pointer to the last node after reversal(1,3) for connection
            // of previous group
            head = curr;
            
            // Dummy.next should only be updated at the reversal of first group
            if(flag==false) dummy.next = prev;
            flag=true;
            
            n-=count;
        }
        return dummy.next;
    }
    
    public static void main(String []ar)
    {
        LinkedListNode head = new LinkedListNode(1);
        head.next  = new LinkedListNode(2);
        head.next.next  = new LinkedListNode(3);
        head.next.next.next  = new LinkedListNode(4);
        head.next.next.next.next  = new LinkedListNode(5);
        
        System.out.println(reverseKGroup(head,2).val);
    }
}
