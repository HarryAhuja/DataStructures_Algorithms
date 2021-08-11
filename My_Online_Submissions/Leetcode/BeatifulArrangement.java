package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;;

public class BeatifulArrangement {

    public static int result = 0;
    
    public static void count_arrangements_helper(int level,int n,int visited)
    {
        if(level > n)
        {
            result++;
        }
        else
        {
            for(int i = 1;i<=n;i++)
            {
                if(((visited>>(i-1))&0x1) == 0 &&
                   ((i%level == 0) || (level%i ==0))
                   )
                {
                    // Setting a bit
                    visited ^= (1<<(i-1));
                    
                    count_arrangements_helper(level+1, n, visited);
                    
                    // Inverting a bit
                    visited ^= (1<<(i-1));  // backtracking
                }
            }
        }
    }
    public static int count_arrangements(int n)
    {
        int visited = 0;
        
        count_arrangements_helper(1,n,visited);
        
        return result;
    }
    public static void main(String[] args) {
        
        int n = 2;
        
        System.out.println(count_arrangements(n));

    }

}
