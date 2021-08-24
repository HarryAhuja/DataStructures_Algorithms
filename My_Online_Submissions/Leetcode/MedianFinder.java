package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class heapComparator implements Comparator<Integer>
{
    public int compare(Integer i1,Integer i2)
    {
        return i2-i1;
    }
}

public class MedianFinder {
    
    PriorityQueue<Integer> min_heap ;
    PriorityQueue<Integer> max_heap;
    double result;
    
    public MedianFinder()
    {
        result   = 0;
        min_heap = new PriorityQueue<Integer>();
        max_heap = new PriorityQueue<Integer>(new heapComparator());
    }
    
    public void addNum(int num) {
        
        int min_heap_size = min_heap.size();
        int max_heap_size = max_heap.size();
        
        if(min_heap_size == max_heap_size)
        {
            if((min_heap.isEmpty() == false) && num>min_heap.peek())
            {
                max_heap.offer(min_heap.poll());
                min_heap.offer(num);
            }
            else
            {
                max_heap.offer(num);
            }
            
            // Result would be always max heap top
            // bcs if we are poping any element from min heap
            // it would be always greater than max heap top
            // so it would be the middle element
            // In case num< top of min heap, that num would be answer
            // In both cases max Heap size is 1 bigger
            
            result = max_heap.peek();
        }
        else if(max_heap_size - min_heap_size == 1)
        {
            // num would come in left half
            if(num<max_heap.peek())
            {
                min_heap.offer(max_heap.poll());
                max_heap.offer(num);
            }
            // add duplicate to right side so that
            // no need for pop
            else
            {
                min_heap.offer(num);
            }
            
            // Use 2.0 instead of 2 to perform double operation
            // and avoid integer operation
            result = (max_heap.peek()+min_heap.peek())/2.0;
        }
    }
    
    public double findMedian()
    {
        return result;
    }
    
    public static void main(String[] args) {
        
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());

    }

}
