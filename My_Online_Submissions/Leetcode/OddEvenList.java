/*
 * If even list then the second last node have to be connected to even head
 * If odd list then the last node have to be connected to even head
 * 
 * Position of statements are important in this question
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class OddEvenList {

    public static void print_list(LinkedListNode head)
    {
        while(head!=null)
        {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static LinkedListNode oddEvenList(LinkedListNode head)
    {
        if(head ==null || head.next==null)  return head;
        
        LinkedListNode odd = head, even = head.next, odd_head = head,even_head = head.next,
                             connector = odd;

        while(true)
        {
            /*
             * Write a top of while bcs there are break statements in between
             * if break happens connector will not point to last odd node
             */
            connector = odd;
            
            if(odd.next!=null)
                odd.next = odd.next.next;
            
            // condition on even for break is bcs in case of odd/even, even
            // will point to null or next null before odd bcs first node is
            // considered as even
            
            if(even==null || even.next==null)   break;
            
            even.next = even.next.next;
            
            odd  = odd.next;
            even = even.next;
            
            
        }
        
        connector.next = even_head;
        
        return odd_head;
    }   
    public static void main(String[] args) {
        
        LinkedListNode head = new LinkedListNode(1);
        head.next           = new LinkedListNode(2);
        head.next.next           = new LinkedListNode(3);
        head.next.next.next           = new LinkedListNode(4);
        head.next.next.next.next          = new LinkedListNode(5);
        print_list(head);
        head = oddEvenList(head);
        print_list(head);
    }

}
