/*
 * This solution is slow since it takes double iteration
 * We know it is palindrome when head reaches back to center
 * but we are still comparing. So double iteration
 * 
 * Stopping at halfway?
 * 1.) find mid and start from mid
 * 2.) We are going till end, If we stop at midway also, recursion
 *     would definitely come back. So complexity remains same
 * 3.) We can track of global variable which will become false 
 *     when scenario hit and based on that we can return at start of func
 * 4.) instead of tracking global, make always local variables.
 *     Each function should be self contained
 * 5.) Not keeping global pointer would introduce one challenge
 *     head will not be incremented globally. So to reflect changes
 *     in head, return node from function.
 *     So either return two values(head+boolean) or keep boolean as
 *     global
 * 6.) This solution condition (is_palindrome==false) also doesn't reduce
 *     time bcs even if the the flag becomes false, this line will not hit
 *     Because we are coming back from recursion and this line is above
 *     the call.
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
    
    public static boolean is_palindrome = true;
    
    public static LinkedListNode is_palindrome_helper(LinkedListNode head,LinkedListNode curr)
    {
        if(curr == null || (is_palindrome==false))    return head;
        
        head = is_palindrome_helper(head,curr.next);
         
        if(head.val != curr.val) is_palindrome = false;
        
        return head.next;
    }
    public static boolean isPalindrome(LinkedListNode head) {
        head =  is_palindrome_helper(head,head);
        return is_palindrome;
    }
    public static void main(String[] args) {
       
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        
        System.out.println(isPalindrome(head));

    }

}
