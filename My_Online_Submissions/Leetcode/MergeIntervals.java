/*
 * Challenges
 * 1.) inp will not be sorted acc to start point
 * 2.) [[1,4],[2,3]] full interval is within another
 * 3.) Use updated list no previous sorted list 
 *     [[1,4],[0,2],[3,5]]
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class NodeComparator implements Comparator<int[]>
{
    public int compare(int[] n1,int[] n2)
    {
        return n1[0]-n2[0];
    }

}

public class MergeIntervals {

    public static int[][] merge_interval(int inp[][])
    {
        int n = inp.length;
        if(n<=1)    return inp;
        
        List<int[]> result = new ArrayList<>();
        Arrays.sort(inp,new NodeComparator());
        
       
       
        int prev_entry[] = inp[0];
        result.add(prev_entry);
        
        int i = 1;
        while(i<n)
        {            
            if(inp[i][0]<=prev_entry[1])
            {
                prev_entry[1] = Math.max(inp[i][1], prev_entry[1]);
            }
            else
            {
                prev_entry = inp[i];
                result.add(prev_entry);
            }
            i++;
        }
        
        // Convert List of 1d array to 2d array
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        int inp[][] = {{1,4},{0,2},{3,5}};
        
        int result[][] = merge_interval(inp);

    }

}
