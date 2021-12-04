/*
 * ---- a----------
 * a1->a2->a3->a4->   ----c-----
 *                  ->c1->c2->c3
 *         b1->b2->
 *         ---b----  
 * 
 * In two iterations(after reaching intersection),distance travelled by
 * A = a+c+b
 * B = b+c+a
 * A == B --> value a,b,c doesn't matter. Sum is same
 * A and B will will after a+c+b(b+c+a) steps
 * if c==0, they will meet at null
 * If the lists never intersected, it's fine too, 
 * because they'll sync up at the end of each list, both of which are null.
 * 
 * Case 1 (Have Intersection & Same Len):
 * Case 2 (Have Intersection & Different Len):
 * Case 3 (Have No Intersection & Same Len):
 * Case 4 (Have No Intersection & Different Len):
 * 
 *  if list A and list B have the same length, this solution will 
 *  terminate in no more than 1 traversal; if both lists have different lengths,
 *   this solution will terminate in no more than 2 traversals
 *   
 *   Suppose difference bw a and b length is x
 *   a = b +x
 *   
 *   After first iteration(when both pointers are reset to other lists)
 *   B = b+c+x (assume b<a)
 *   A = a+c
 *   
 *   A-B = a-b-x = 0 (a = b+x)
 *   that means this first iteration has counter acted the difference bw
 *   length of LL. Therefore value of x doesn't matter
 *   Now both A and B are equidistant from intersection point
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class IntersectionLinkedList {
    public LinkedListNode getIntersectionNode(LinkedListNode headA, LinkedListNode headB) {
        
        LinkedListNode a = headA;
        LinkedListNode b = headB;
        
        while(a!=b)
        {
            a = (a==null)?headB:a.next;
            b = (b==null)?headA:b.next;
        }
        
        return a;
    }
}
