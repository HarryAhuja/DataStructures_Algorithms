/*
 * Challenges
 * 1.) inp will not be sorted acc to start point
 * 2.) [[1,4],[2,3]] full interval is within another
 * 3.) Use updated list no previous sorted list 
 *     [[1,4],[0,2],[3,5]]
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class NodeComparator implements Comparator<Node>
{
    public int compare(Node n1,Node n2)
    {
        return n1.start-n2.start;
    }

}

class Node
{
    int start;
    int end;
    
    public Node()
    {
        start = 0;
        end   = 0;
    }
    public Node(int s,int e)
    {
        start = s;
        end   = e;
    }
}
public class MergeIntervals {

    public static int[][] merge_interval(int inp[][])
    {
        int n = inp.length;
        if(n==0)    return new int[1][2];
        
        List<Node> list = new ArrayList<>();
        ArrayList<Node> sorted = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            sorted.add(new Node(inp[i][0],inp[i][1]));
        }
        
        Collections.sort(sorted,new NodeComparator());
       
        list.add(new Node(sorted.get(0).start,sorted.get(0).end));
        int i = 1;
        
        while(i<n)
        {
            int prev_start = list.get(list.size()-1).start;
            int prev_end   = list.get(list.size()-1).end;
            int curr_start = sorted.get(i).start;
            int curr_end   = sorted.get(i).end;
            
            if(curr_end<=prev_end)
            {
                list.remove(list.size()-1);
                list.add(new Node(prev_start,prev_end));
                
            }
            else if(curr_start<=prev_end)
            {
                list.remove(list.size()-1);
                list.add(new Node(prev_start,curr_end));
            }
            else
            {
                list.add(new Node(curr_start,curr_end));
            }
            
            i++;
        }
        
        int result[][] = new int[list.size()][2];
        
        for(i=0;i<list.size();i++)
        {
            result[i][0] = list.get(i).start;
            result[i][1] = list.get(i).end;
        }
        
        return result;
    }
    public static void main(String[] args) {
        int inp[][] = {{1,4},{0,2},{3,5}};
        
        int result[][] = merge_interval(inp);

    }

}
