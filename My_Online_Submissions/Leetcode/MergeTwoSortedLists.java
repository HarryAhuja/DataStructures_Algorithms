/**
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

/**
 * @author Ahuja
 *
 */
public class MergeTwoSortedLists {

    public static LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {
        
        LinkedListNode result = null;
        
        if(l1==null)        result = l2;
        else if(l2 == null) result = l1;
        else if(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                result = l1;
                l1 = l1.next;
            }
            else
            {
                result = l2;
                l2 = l2.next;
            }
            
            LinkedListNode iter = result;
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
            
            if(l1!=null)    iter.next = l1;
            else            iter.next = l2;
        }
        
        return result;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
