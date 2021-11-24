/*
 * Its a Abstract DS in which services are provided
 * enqueue, deque, front, isEmpty-> O(1)
 * Insertion and deletion at opposite ends
 * First in first out(FIFO)
 * 
 * Assuming rear on right and front at left
 * 
 *          front           rear
 * 0    1   2   3   4   5   6   7   8   
 * 
 * Actual queue is from [front,rear]
 * rest of elements are free to expand the queue 
 * 
 * Enqueue: put at rear and increment
 * Dequeue: just increment front pointer(old values treated as garbage) doesn't matter
 * as it will not be part of queue now
 * 
 * For empty queue, front=rear=-1
 * 
 * This approach has wastage of memory cells
 * 
 * to reuse the cells again, use circular queue
 * 
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class QueueUsingDS {

    private static int rear,front, capacity;
    private static int queue[];
    
    public QueueUsingDS(int c)
    {
        capacity = c;
        queue    = new int[c];
        rear     = -1;
        front    = -1;
    }
    
    public static boolean isEmpty()
    {
        // representing front and rear at -1 as empty
        if(front==-1 && rear==-1)   return true;
        else                        return false;
    }
    
    public static boolean isFull()
    {
        return (rear==capacity);
    }
    
    public void enqueue(int x)
    {
        if(isFull()==true)  return;
        else if(isEmpty()==true)
        {
            front = rear = 0;
        }
        else
        {
            rear++;
        }
        
        queue[rear] = x;
    }
    
    public static int deque()
    {
        if(isEmpty())   return -1;
        else if(front==rear)
        {
            // Only single element in queue
            // -1 condition already checked in isEmpty
            // dequeue will make queue empty
            int element = queue[front];
            front = rear = -1;
            return element;
        }
        else
        {
            front++;
            return queue[front-1];
        }
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
