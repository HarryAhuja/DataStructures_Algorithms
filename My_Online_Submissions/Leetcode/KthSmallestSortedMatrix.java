package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class maxComparator implements Comparator<Integer>
{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
    
}

public class KthSmallestSortedMatrix {
  
    public static int k_smallest_element(int mat[][], int k)
    {
        int rows = mat.length;
        int cols = mat[0].length;
        
        PriorityQueue<Integer> pq= new PriorityQueue<>(rows*cols,new maxComparator());
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                pq.offer(mat[i][j]);
                if(pq.size()>k) pq.poll();
            }
        }
        
        return pq.peek();
    }
    public static void main(String[] args) {
        
        int mat[][] = {{1,5,9},{10,11,13},{12,13,15}};
        int k       = 8;
        
        System.out.println(k_smallest_element(mat,k));

    }

}
