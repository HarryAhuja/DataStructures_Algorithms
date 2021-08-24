/*
 * This gives time limit exceeds since
 * pq.remove(last_element) doesnt take log(k), instead take O(k)
 * 
 * So total complexity is O(nk)
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class Node
{
    int key;
    int index;
    
    public Node()
    {
        key   = -1;
        index = -1;
    }
    
    public Node(int k,int i)
    {
        key   = k;
        index = i;
    }
}
class Compare implements Comparator<Node>
{
    @Override
    public int compare(Node o1, Node o2) {
        return o2.key-o1.key;
    }
    
}
public class SlidingWindowMaxiumum {

    public static int[] find_max_slide_window(int inp[],int k)
    {
        int n = inp.length;
        
        if(n==0 || k==0 || n<k)    return new int[0];
        
        int result[] = new int[n-k+1];
        int result_index = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>(k,new Compare());
        
        int i = 0;
        
        while(i<k && i<n)
        {
            pq.offer(new Node(inp[i],i));
            i++;
        }
        
        result[result_index++] = pq.peek().key;
        
        if(i==n)    return result;

        while(i<n)
        {
            int curr_element = inp[i];
            
            pq.add(new Node(curr_element,i));
            
            while((pq.isEmpty() == false) && (pq.peek().index<(i-k+1)))
            {
                pq.poll();
                
            }

            result[result_index++] = pq.peek().key;
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
