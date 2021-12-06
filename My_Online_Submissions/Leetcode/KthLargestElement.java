/*
 * Approach 1:
 * Min priority queue (default when constructed)
 * is used bcs while adding bigger number, we have to delete
 * minimum number. So in min PQ, min will be obtained in logn
 * At the end, queue will contain k element where top of min PQ
 * will be kth largest element in array
 * 
 * TC = O(nlogk)-> k size heap only + O(k) space
 * 
 * Approach 2nd
 * Build Min/Max heap of array = O(n)
 * Extract k times
 * 
 * when to use min heap-> if we want kth largest element than from max heap, we 
 * have to extract k times and from min heap, we have to extract n-k+1 times
 * 
 * TC
 * min heap  = O(n)-> building heap + O((n-k+1)*log(n))
 * max heap  = O(n)-> building heap + O(k*log(n))
 * 
 * So if n-k+1<k than use min heap, otherwise max heap
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.Arrays;

public class KthLargestElement {
    
    public static void swap(int inp[],int a,int b)
    {
        int temp = inp[a];
        inp[a]   = inp[b];
        inp[b]   = temp;
    }
    
    public static void shuffle(int inp[])
    {
        Random random = new Random();
        
        for(int i=1;i<inp.length;i++)
        {
            // between 0 (inclusive) and i+1 (exclusive).
            int r = random.nextInt(i+1);
            swap(inp,i,r);
        }
    }
    
    public static int partition(int inp[],int low,int high)
    {
        int pivot = inp[high];
        int index = low;
        
        for(int i=low;i<high;i++)
        {
            if(inp[i]<=pivot)
            {
                swap(inp,i,index);
                index++;
            }
        }
        
        swap(inp,index,high);
        
        return index;
        
    }
    public static int find_kth_largest(int inp[], int k)
    {
        int n = inp.length;
        
        if(n==0 || n<k) return -1;
           
        // to make it random and approach avg case:
        shuffle(inp);
        
        int low  = 0;
        int high = n-1;
        int target_index = n-k;
        
        // one element is already sorted
        while(low<high)
        {
            int partition_index = partition(inp,low,high);
            
            if(partition_index == target_index)
            {
                return inp[partition_index];
            }
            else if(partition_index>target_index)
            {
                high = partition_index-1;
            }
            else
            {
                low = partition_index +1;
            }
        }
        return inp[low];
    }

    public static void main(String[] args) {
        int inp[] = {3,2,3,1,2,4,5,5,6};
        int k     = 2;
        
        System.out.println(find_kth_largest(inp,k));
    }

}
