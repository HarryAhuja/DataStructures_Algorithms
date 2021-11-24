/*
 * Problems with array
 * 
 * 1.) if capacity is very large and filled cells are less(sparsely filled) then memory wastage
 * 2.) if queue is full and we want to insert element then we have to make new big array and copy
 *     all elements in O(n)
 *     
 *     
 * All apis should be of constant time : Major requirement
 * 
 * Assuming (can be opposite)
 * enqueue: head of LL
 * dequeue: tail of LL
 * 
 * if i do so, dequeue will be in O(n)bcs we need parent pointer(or DLL) to go backwards
 * to update front
 * 
 * Now if do like this
 * enqueue: tail of LL
 * dequeue: head of LL
 * 
 * Now both will be by O(1) by global tail pointer. Difference is here we need to go
 * forward after inserting not backwards. So no parent pointer is needed
 * 
 * How to check isFull of LL implementation
 * 
 * while enqueue if new operator returns null?
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class QueueUsingDS {

    private static LinkedListNode rear,front;
    private static int capacity;
    
    public QueueUsingDS()
    {
        rear     = null;
        front    = null;
    }
    
    public static boolean isEmpty()
    {
        // representing front and rear at null as empty
        if(front==null && rear==null)   return true;
        else                        return false;
    }
    
    public void enqueue(int x)
    {
        LinkedListNode new_node = new LinkedListNode(x);
        
        if(isEmpty())
        {
            rear = front = new_node;
        }
        else
        {
            rear.next = new_node;
            rear = new_node;
        }
        
    }
    
    public static int deque()
    {
        if(isEmpty()==true) return -1;
        else if(front==rear)
        {
            // Single element
            // make queue empty after this pop
            int element = front.val;
            front = rear = null;
            return element;
        }
        else
        {
            int element = front.val;
            front = front.next;
            return element;
            // popped element should be eligible for GC otherwise memory wastage
        }
    }
    
    public static int front()
    {
        if(isEmpty()==true) return -1;
        return front.val;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
