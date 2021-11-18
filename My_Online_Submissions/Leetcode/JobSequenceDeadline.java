package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Job
{
    char job_id;
    Integer deadline;       // Integer bcs Integer implements comparable not in
    Integer profit;         // to invoke compareTo()
    
    public Job()
    {
        job_id = '\0';
        deadline = 0;
        profit = 0;
    }
    
    public Job(char id,int d,int p)
    {
        job_id = id;
        deadline = d;
        profit = p;
    }
    
    public int printJobScheduling(ArrayList<Job> list,int slots)
    {
        int max_profit = 0;
        int n          = list.size();
        
        if(n==0)    return 0;
        
        Collections.sort(list, new Comparator<Job>() {
            
            public int compare(Job j1, Job j2)
            {
                return -1*j1.profit.compareTo(j2.profit);
            }
        });
        
        // 0-1 info is stored in index=1
        boolean result[] = new boolean[slots+1];    // starting from 1
        int count = 0;
        int i     = 0;
        
        while(i<n && count<slots)
        {
            Job current_job = list.get(i);
            int deadline    = current_job.deadline;
            int profit      = current_job.profit;
            
            while(deadline>0 && result[deadline]==true)
            {
                deadline--;
            }
            
            if(deadline!=0)
            {
                result[deadline] = true;
                max_profit+=profit;
            }
            else
            {
                // Job rejected
                // no slot availalable
            }
           
            i++;
        }
        
        return max_profit;
    }
}

public class JobSequenceDeadline {

    public static void main(String[] args) {
        
        ArrayList<Job> arr = new ArrayList<Job>();
        
        arr.add(new Job('a', 2, 20));
        arr.add(new Job('b', 2, 15));
        arr.add(new Job('c', 1, 10));
        arr.add(new Job('d', 3, 5));
        arr.add(new Job('e', 3, 1));
        
        // Function call
        System.out.println("Following is maximum "
                           + "profit sequence of jobs");
  
        Job job = new Job();
  
        // Calling function
        System.out.println(job.printJobScheduling(arr, 4));

    }

}
