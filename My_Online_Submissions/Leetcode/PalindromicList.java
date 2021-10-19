/*
 * This requires modification in input of list
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

class LinkedListNode
{
    int val;
    LinkedListNode next;
    LinkedListNode() {}
    LinkedListNode(int val) { this.val = val; }
    LinkedListNode(int val, LinkedListNode next) { this.val = val; this.next = next; }
}

public class PalindromicList {
    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode prev = null;
        while (head != null) {
            LinkedListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public static boolean isPalindrome(LinkedListNode head) {
        
        LinkedListNode fast = head, slow = head;
        
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // Let right half be smaller
        if(fast!=null)  slow = slow.next;
        
        slow = reverse(slow);
        
        fast = head;
        
        while(slow!=null)
        {
            if(slow.val!=fast.val)  return false;
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
    public static void main(String[] args) {
       
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(2);
        head.next.next.next = new LinkedListNode(1);
        
        System.out.println(isPalindrome(head));

    }

}
