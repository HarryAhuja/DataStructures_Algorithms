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
        
        LinkedListNode odd = head, even, odd_head = head,even_head = head.next,connector = null;
        int count = 0;
        
        while(odd!=null)
        {
            // Keep it on top to place connector at right place
            // if kept at last, connector will be wrong for odd nodes
            count++;
            if((count&0x1)==1)  connector = odd;
            
            even = odd.next;
            
            if(even == null)    break;
            
            odd.next = even.next;
           
            // change odd to next node at last always
            // after all operations
            odd  = even;
            
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
