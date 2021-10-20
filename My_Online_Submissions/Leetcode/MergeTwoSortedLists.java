/**
 * To handle initialsation issue of head, create dummy node
 * and include head operation also with normal operation
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

/**
 * @author Ahuja
 *
 */
public class MergeTwoSortedLists {

    public static LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {
        
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode iter  = dummy;
        
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                iter.next = l1;
                l1 = l1.next;
            }
            else
            {
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }
        if(l1==null)    iter.next = l2;
        else            iter.next = l1;
        
        return dummy.next;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
