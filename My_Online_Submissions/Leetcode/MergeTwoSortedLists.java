/**
 * I don't like this approach. Because in real life, the length of a linked list 
 * could be much longer than we expected, in which case the recursive approach is 
 * likely to introduce a stack overflow. (Imagine a file system)
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

/**
 * @author Ahuja
 *
 */
public class MergeTwoSortedLists {

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
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
