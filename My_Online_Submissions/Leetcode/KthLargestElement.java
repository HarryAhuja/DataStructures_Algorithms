/*
 * Min priority queue (default when constructed)
 * is used bcs while adding bigger number, we have to delete
 * minimum number. So in min PQ, min will be obtained in logn
 * At the end, queue will contain k element where top of min PQ
 * will be kth largest element in array
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.PriorityQueue;

import java.util.Arrays;

public class KthLargestElement {
    
    public static int find_kth_largest(int inp[], int k)
    {
        int n = inp.length;
        
        if(n==0 || n<k) return -1;
           
        Arrays.sort(inp);
        
        return inp[n-k];
    }

    public static void main(String[] args) {
        int inp[] = {3,2,3,1,2,4,5,5,6};
        int k     = 2;
        
        System.out.println(find_kth_largest(inp,k));
    }

}
