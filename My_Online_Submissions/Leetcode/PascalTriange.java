/*
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriange {
    public static List<List<Integer>> generate(int num_rows) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        
        for(int i=0;i<num_rows;i++)
        {
            l.add(new ArrayList<>());
            for(int j=0;j<=i;j++)
            {
                if(j==0 || j==i)    l.get(i).add(1);
                else
                {
                    int a = l.get(i-1).get(j);
                    int b = l.get(i-1).get(j-1);
                    l.get(i).add(a+b);
                }
            }
        }
        return l;
    }
    public static void main(String[] args) {
        
        List<List<Integer>> l = generate(5);
        System.out.println(l);
    }
}
