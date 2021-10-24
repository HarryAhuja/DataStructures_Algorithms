/*
 * Advantage is we, don't have to traverse whole list if not required
 * even though fast is traversing full list
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Stack;

class LinkedListNode
{
    int val;
    LinkedListNode next;
    LinkedListNode() {}
    LinkedListNode(int val) { this.val = val; }
    LinkedListNode(int val, LinkedListNode next) { this.val = val; this.next = next; }
}

public class PalindromicList {
    
    public static boolean isPalindrome(LinkedListNode head) {
        
        Stack<Integer> stack = new Stack<>();
        
        LinkedListNode fast = head, slow = head;
        
        while(fast!=null && fast.next!=null)
        {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        //Point to starting of second half    
        if(fast!=null)  slow = slow.next;
        
        while(slow!=null)
        {
            Integer top = stack.pop();
            if(slow.val!=top)   return false;
            
            slow = slow.next;
        }
        return true;
    }
    public static void main(String[] args) {
        // 1->2
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);

        
        System.out.println(isPalindrome(head));

    }

}
