package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class ReverseLLGroupK
{
    public LinkedListNode reverseKGroup(LinkedListNode head, int k)
    {
        LinkedListNode temp = head;
        
        int i = 0;
        while(temp!=null)
        {
            temp=temp.next;
            i++;
        }
        
        if(i<k) return head;
        
        LinkedListNode prev = null, curr = head , next = null;
        
        int count = 0;
        
        // Reversing first k nodes
        while(curr!=null && count<k)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        if(next!=null)
            head.next = reverseKGroup(next, k);
        
        return prev;
    }
}
