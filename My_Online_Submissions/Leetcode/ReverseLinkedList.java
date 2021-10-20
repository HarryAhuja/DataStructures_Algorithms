package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class ReverseLinkedList {
    public static void print_list(LinkedListNode head)
    {
        while(head!=null)
        {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println("");
    }
    public static LinkedListNode reverseList(LinkedListNode head) {
        
        if(head == null)    return head;
        
        LinkedListNode curr = head, prev = null, next;
        
        while(curr!=null)
        {
            next      = curr.next;
            curr.next = prev;
            prev      = curr;
            curr      = next;
        }
        return prev;
    }
    
    public static void main(String[] args) {
       
        LinkedListNode head = new LinkedListNode(1);

        print_list(head);
        
        head = reverseList(head);
        
        print_list(head);

    }

}
