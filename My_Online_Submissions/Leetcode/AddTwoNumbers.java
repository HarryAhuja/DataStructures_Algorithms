/*
 * In place 3s cases
 * 1.) l1 len ==l2 len -> add last node if carry
 * 2) if l1>l2 -> same case, add 0 when l2 is null
 * 3.) if l1<l2-> use l1 full length and then connect it to longer part of l2
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class AddTwoNumbers {
    
    public static void print_list(LinkedListNode head)
    {
        while(head!=null)
        {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
        
        if(l1 == null)      return l2;
        else if(l2==null)   return l1;
        
        LinkedListNode iter1 = l1, iter2 = l2;
        
        LinkedListNode temp = l1 , prev = null;
        
        int carry = 0;

        while(iter1!=null || iter2!=null)
        {
            int sum = (iter1==null?0:iter1.val)+(iter2==null?0:iter2.val) + carry;
            
            if(temp!=null)
            {
                // do nothing
            }
            else
            {
                temp = iter2;
                prev.next = temp;
            }
            temp.val = (sum%10);
            
            carry = sum/10;
            
            prev = temp;
            
            temp  = temp.next;
            iter1 = (iter1==null?null:iter1.next);
            iter2 = (iter2==null?null:iter2.next);
        }
        
        if(carry==1) prev.next = new LinkedListNode(1);    
        
        return l1;
    }
    public static void main(String[] args) {
        
        LinkedListNode head1 = new LinkedListNode(9);
        head1.next           = new LinkedListNode(9);
        head1.next.next      = new LinkedListNode(9);
        head1.next.next.next      = new LinkedListNode(9);
        head1.next.next.next.next      = new LinkedListNode(9);
        head1.next.next.next.next.next      = new LinkedListNode(9);
        head1.next.next.next.next.next.next      = new LinkedListNode(9);
        
        LinkedListNode head2 = new LinkedListNode(9);
        head2.next           = new LinkedListNode(9);
        head2.next.next      = new LinkedListNode(9);
        head2.next.next.next = new LinkedListNode(9);
        
        print_list(head1);
        print_list(head2);
        
        print_list(addTwoNumbers(head1,head2));

    }

}
