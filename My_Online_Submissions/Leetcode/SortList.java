/*
 *  4-2-1-3-5-6-7
 *  when mid is 3, we will pass list of left as 4 to 3
 *  and will again find its mid but mid condtion is last node->null
 *  But we haven't set it to null
 *  is it required?
 *  
 *  Solution : Don't modify the list, pass tail as param
 *  and put stopping condition on that
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.LinkedList;

public class SortList {
    public static void print_list(LinkedListNode head)
    {
        while(head!=null)
        {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;

        LinkedListNode result;
        
        if(l1.val<l2.val)
        {
            result = l1;
            result.next = mergeTwoLists(l1.next, l2);
        }
        else
        {
            result = l2;
            result.next = mergeTwoLists(l1, l2.next);
        }
        
        return result;
        
    }
    
    public static LinkedListNode find_mid(LinkedListNode head,LinkedListNode tail)
    {
        // Odd LL   -> middle node
        // Even LL - > starting node of second half
        // But in this question bcs we have to pass start and end of list
        // We have to get the last node of first half in even node
        LinkedListNode fast = head, slow = head;
        
        while(fast!=tail && fast.next!=tail)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public static LinkedListNode sortList_helper(LinkedListNode head,LinkedListNode tail) {
        
        if(head == tail)
        {
            LinkedListNode new_list = new LinkedListNode(head.val);
            return new_list;
        }
        
        LinkedListNode mid         = find_mid(head,tail);
        LinkedListNode left        = sortList_helper(head, mid);
        LinkedListNode right       = sortList_helper(mid.next, tail);
        LinkedListNode merged_list = mergeTwoLists(left, right);
        
        return merged_list;
    }
    
    public static LinkedListNode sortList(LinkedListNode head)
    {
        if(head == null)    return head;
        
        LinkedListNode tail = head;
        while(tail.next!=null)
        {
            tail = tail.next;
        }
        
        return sortList_helper(head, tail);
    }
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(4);
        head.next           = new LinkedListNode(2);
        head.next.next           = new LinkedListNode(1);
        head.next.next.next           = new LinkedListNode(3);
        
        print_list(head);
        
        head = sortList(head);
        
        print_list(head);
        
    }

}
