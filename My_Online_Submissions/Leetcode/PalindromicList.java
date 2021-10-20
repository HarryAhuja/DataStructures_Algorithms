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
    public static LinkedListNode reverse(LinkedListNode head)
    {
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
        // 1.) In case of odd nodes, skip central node so that to reverse from next node
        // 2.) while(slow!=null) -> slow can become null before
        //     first half 
        // 3.) if we don't make it smaller then also it will work
        //     bcs for LL 1->2->2->3->2->2->1
        // Right half  null<-3<-2<-2<-1
        // Left  half  1->2->2->3->.....(didn't change to null)
        // bcs its still connected comparison of 3 would be done correct
        
        if(fast!=null)  slow = slow.next;
        
        // last node of first half is still connected(not null)
        slow = reverse(slow);
        
        fast = head;
        
        // putting condition on slow not fast because last node of fast
        // is not connected to null
        // So in case of even node, equal halves, doesn't matter
        // slow and fast will reach to null at same time
        while(slow!=null)
        {
            if(slow.val!=fast.val)  return false;
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
    public static void main(String[] args) {
        // 1->2->2->3->2->2->1
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(2);
        head.next.next.next = new LinkedListNode(2);
        head.next.next.next.next = new LinkedListNode(2);
        head.next.next.next.next.next = new LinkedListNode(1);
        
        System.out.println(isPalindrome(head));

    }

}
