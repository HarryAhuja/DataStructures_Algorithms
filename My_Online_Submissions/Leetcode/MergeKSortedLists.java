package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode
{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class ListNodeComparator implements Comparator<ListNode>
{
    @Override
    public int compare(ListNode o1, ListNode o2) {
        return o1.val-o2.val;
    }
    
}

public class MergeKSortedLists {

    public static ListNode insert(ListNode list, int data)
    {
        // Create a new node with given data
        ListNode new_node = new ListNode(data);
        new_node.next = null;
   
        // If the Linked List is empty,
        // then make the new node as head
        if (list== null) {
            list= new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            ListNode last = list;
            while (last.next != null) {
                last = last.next;
            }
   
            // Insert the new_node at last node
            last.next = new_node;
        }
   
        // Return the list by head
        return list;
    }
    
    public static ListNode merge_sorted(ListNode[] lists)
    {
        ListNode head = null;
        
        int k = lists.length;
        
        if(k==0)    return head;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(k,new ListNodeComparator());
        
        for(int i=0;i<k;i++)
        {
            if(lists[i]!=null)
            {
                pq.offer(lists[i]);
            }
        }
        
        ListNode temp = head;
        
        while(pq.isEmpty()==false)
        {
            ListNode top = pq.poll();
            
            if(head == null)
            {
                head = new ListNode(top.val,null);
                temp = head;
            }
            else
            {
                temp.next = new ListNode(top.val,null);
                temp      = temp.next;
            }
            
            if(top.next!=null)  pq.offer(top.next);
        }
        
        return head;
        
    }
    
    public static void main(String[] args) {
        
        int n = 3;
        
        ListNode[] lists = new ListNode[n];
        
        lists[0] = insert(lists[0],1);
        lists[0] = insert(lists[0],4);
        lists[0] = insert(lists[0],5);
        
        lists[1] = insert(lists[1],1);
        lists[1] = insert(lists[1],3);
        lists[1] = insert(lists[1],4);
        
        lists[2] = insert(lists[2],2);
        lists[2] = insert(lists[2],6);
        
        ListNode head = merge_sorted(lists);
        
        while(head!=null)
        {
            System.out.print(head.val+" ");
            head= head.next;
        }
        

    }

}
