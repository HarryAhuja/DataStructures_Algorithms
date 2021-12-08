/*
 * Challenges
 * 1.) inp will not be sorted acc to start point
 * 2.) [[1,4],[2,3]] full interval is within another
 * 3.) Use updated list not previous sorted list 
 *     [[1,4],[0,2],[3,5]]
 *     
 *  after sorting starting point, these can be scenarios
 *  
 *  ----------      ---------       -> equal start-> end would be max of both
 *  ------          ------------    -> in overlapped interval
 *  
 *  
 *  ----------      ---------       -> unequal but overlapped with end-> end would be max of both
 *    ------          ------------  -> in overlapped interval
 *  
 *  ------              -> not overlapped
 *          -------
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
        // sort acc to starting point
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
        
       
        // this is new overlapped interval
        int prev_entry[] = inp[0];
        
        // we are adding array reference to list
        // that means we can change the element inside the list after adding also
        result.add(prev_entry);
        // first entry is added as such in the list
        // if any overlapping interval, it will be updated in the list
        
        int i = 1;
        while(i<n)
        {            
            // if current starting point <= prev end point
            if(inp[i][0]<=prev_entry[1])
            {
                // element inside the list is updated
                prev_entry[1] = Math.max(inp[i][1], prev_entry[1]);
            }
            else
            {
                prev_entry = inp[i];
                result.add(prev_entry);
                // add new entry in list
                // if any overlapping interval with this, update inside the list
                // if not remain as it is the list
            }
            i++;
        }
        
        // Convert List of 1d array to 2d array
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        int inp[][] = {{1,4},{0,2},{3,5}};
        
        int result[][] = merge_interval(inp);
        for(int i=0;i<result.length;i++)
        {
            for(int j=0;j<result[0].length;j++)
                System.out.print(result[i][j]+" ");
            System.out.println();
        }
        

    }

}
