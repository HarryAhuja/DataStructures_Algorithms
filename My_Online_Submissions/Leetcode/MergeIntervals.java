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

class Interval
{
    int start;
    int end;
    
    public Interval()
    {
        start = 0;
        end   = 0;
    }
    public Interval(int s,int e)
    {
        start = s;
        end   = 0;
    }
}

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
        
        List<Interval> result = new ArrayList<>();
        Arrays.sort(inp,new NodeComparator());
        

        int start = inp[0][0];
        int end   = inp[0][1];
        
        int i = 1;
        while(i<n)
        {            
            // if current starting point <= prev end point
            if(inp[i][0]<=end)
            {
                end = Math.max(inp[i][1], end);
            }
            else
            {
                // add the disjoint not overlapped interval
                result.add(new Interval(start,end));
                
                start = inp[i][0];
                end   = inp[i][1];
            }
            i++;
        }
        // add last interval
        result.add(new Interval(start,end));
        
        
        int ans[][] = new int[result.size()][2];
        for(int x=0;x<result.size();x++)
        {
            ans[x][0] = result.get(x).start;
            ans[x][1] = result.get(x).end;
        }
        return ans;
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
