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
        
        // head.next is important bcs we dont want to do anything with last node
        // its next pointer is changed from its previous node not at itself 
        // iteration
        if(head == null || head.next==null)    return head;
        
        LinkedListNode sub_ans = reverseList(head.next);
        
        // don't use sub_ans.next = head bcs
        // head should change on each iteration but sub_ans always remain
        // same bcs at end also we have to return last node
        head.next.next = head;
        head.next = null;
        
        return sub_ans;
    }
    
    public static void main(String[] args) {
       
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        print_list(head);
        
        head = reverseList(head);
        
        print_list(head);

    }

}
