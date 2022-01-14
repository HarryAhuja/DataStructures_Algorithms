package datastructures.DataStructures_Algorithms.My_Online_Submissions.Online_Assessment;

import java.util.Comparator;
import java.util.PriorityQueue;

class MyComparator implements Comparator<Integer>
{

    @Override
    public int compare(Integer o1, Integer o2)
    {
        return o2.compareTo(o1);
    }
    
}

public class Logistics
{
    public static int get_min(int w[])
    {
        int n = w.length;
        
        if(n==0 || n==1)    return 0;
        
        int ans = 0;
        
        for(int len=2;len<=n;len++)
        {
            int start = 0;
            int end   = n-1;
            
            PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();
            PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>(new MyComparator());
            
            while(start<len)
            {
                min_heap.add(w[start]);
                max_heap.add(w[start]);
                start++;
            }
            
            ans+=(max_heap.peek()-min_heap.peek());
             
            while(start<=end)
            {
                
                max_heap.remove(w[start-len]);
                min_heap.remove(w[start-len]);
                
                min_heap.add(w[start]);
                max_heap.add(w[start]);
                
                ans+=(max_heap.peek()-min_heap.peek());
                
                start++;
            }
        }
        return ans;
    }
    public static void main(String a[])
    {
        int w[] = {3,1,10,7,5,2};
        System.out.println(get_min(w));
    }
}
