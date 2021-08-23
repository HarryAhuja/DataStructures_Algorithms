/*
 * Instead of having 2 pointers, I want one pointer each at
 * one starting of row so that i can compare all the elements
 * and move the pointer which is smallest
 * 
 * This can be done with the help of min Heap
 * Which ever number is smallest, fetch its row and col from heap
 * and move the pointer
 * 
 * After iterating k times, top of min Heap will give kth 
 * smallest element
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class matrixComparator implements Comparator<int[]>
{

    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0]-o2[0];
    }
    
}

public class KthSmallestSortedMatrix {
  
    public static int k_smallest_element(int mat[][], int k)
    {

        int rows = mat.length;
        int cols = mat[0].length;
        
        if(k==1)    return mat[0][0];    
        
        PriorityQueue<int[]> pq= new PriorityQueue<>(rows*cols,new matrixComparator());
        
        /*
        Run for minimum of rows and k bcs
        1.) consider ans is in col=0 and rows, then kth element
            would be among first k elements
        2.) if col>0, then ans would be in <k rows
        3.) Conclusion, you don't need to add elements>k*cols to find kth element
            It it will always within k*cols where min value of cols=1
        */
        for(int i=0;i<Math.min(rows, k);i++)
        {   
            pq.offer(new int[] {mat[i][0],i,0});
        }
        
        // iterate over k times
        for(int i=1;i<k;i++)
        {
            int top[] = pq.poll();
            int r = top[1], c = top[2];
            
            // check Next Col
            // if cols of particular row is exhaused, that
            // means all elements in that row are checked, no need
            // to check that row further
            if(c+1<cols)   
            {
                pq.offer(new int[] {mat[r][c+1],r,c+1});
            }
            
        }
        
        return (pq.peek())[0];
    }
    public static void main(String[] args) {
        
        int mat[][] = {{1,5,9},{10,11,13},{12,13,15}};
        int k       = 8;
        
        System.out.println(k_smallest_element(mat,k));

    }

}
