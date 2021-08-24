package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class Compare implements Comparator<Integer>
{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
    
}
public class SlidingWindowMaxiumum {

    public static int[] find_max_slide_window(int inp[],int k)
    {
        int n = inp.length;
        
        if(n==0 || k==0 || n<k)    return new int[0];
        
        int result[] = new int[n-k+1];
        int result_index = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k,new Compare());
        
        int i = 0;
        
        while(i<k && i<n)
        {
            pq.offer(inp[i++]);
        }
        
        result[result_index++] = pq.peek();
        
        if(i==n)    return result;

        while(i<n)
        {
            int last_element = inp[i-k];
            int curr_element = inp[i];
            
            pq.remove(last_element);
            
            pq.add(curr_element);
            
            result[result_index++] = pq.peek();
            i++;
        }
        
        return result;
    }
    public static void main(String[] args) {
        
        int nums[] = {4,-2}, k = 2;
        
        int result[] = find_max_slide_window(nums,k);
        
        for(int i=0;i<result.length;i++)
        {
            System.out.print(result[i]+" ");
        }

    }

}
