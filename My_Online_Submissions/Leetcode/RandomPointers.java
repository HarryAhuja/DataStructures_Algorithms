/*
 *  Problem is when creating deep copy, we can assign random pointers
 *  but random pointer can point to a node which is not created yet
 *  So multiple passes are required
 *  
 *  TC
 *  1.) if 1/2 nodes
 *  2.) Self random pointer
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

class RandomNode
{
    int val;
    RandomNode next;
    RandomNode random;
    public RandomNode()     {val = -1;next = random = null;}
    public RandomNode(int v){val = v; next=random = null;}
}

public class RandomPointers {
    public static void print_list(RandomNode head)
    {
        while(head!=null)
        {
            System.out.print(head.val+" ");
            if(head.random!=null)   System.out.print(head.random.val);
            else                    System.out.print("null");
            head = head.next;
        }
        System.out.println();
    }
    public static  RandomNode copyRandomList(RandomNode head) {
        
        if(head == null)    return head;
        
        RandomNode iter = head;
        
        // First pass: Connect new nodes side by side
        while(iter!=null)
        {
            RandomNode new_node = new RandomNode(iter.val);
            RandomNode next     = iter.next;
            new_node.next       = next;
            iter.next           = new_node;
            iter                = new_node.next;
        }
        
        //Second pass: Fix random pointers of new nodes
        iter = head;
        while(iter!=null)
        {
            RandomNode orig_random_pointer = iter.random;
            RandomNode copy_node = iter.next;
            
            if(orig_random_pointer!=null)   copy_node.random = orig_random_pointer.next;
            
            iter = iter.next.next;
        }
        
        //Third pass: Separate original and copy list
        iter = head;
        RandomNode copy_head = head.next;
        
        while(iter!=null && iter.next!=null)
        {
            RandomNode next = iter.next;
            iter.next       = next.next;
            iter = next;
        }
        
        return copy_head;
    }
    public static void main(String a[]) {
        
        RandomNode head = new RandomNode(-1);
        head.random = head;

        print_list(head);
        
        head = copyRandomList(head);
        
        print_list(head);
    }

}
