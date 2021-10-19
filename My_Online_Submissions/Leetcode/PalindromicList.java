/*
 * This solution is slow since it takes double iteration
 * We know it is palindrome when head reaches back to center
 * but we are still comparing. So double iteration
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
    
    static LinkedListNode low;
    
    public static boolean is_palindrome_helper(LinkedListNode head)
    {
        if(head == null)    return true;
        
        boolean sub_ans = is_palindrome_helper(head.next);
         
        if(low.val != head.val) return false;
        
        low = low.next;
        
        return sub_ans;
    }
    public static boolean isPalindrome(LinkedListNode head) {
        
        low = head;
        return is_palindrome_helper(head);
        
    }
    public static void main(String[] args) {
       
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(2);
        head.next.next.next = new LinkedListNode(1);
        
        System.out.println(isPalindrome(head));

    }

}
