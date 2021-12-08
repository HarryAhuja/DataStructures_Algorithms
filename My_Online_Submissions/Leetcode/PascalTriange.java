/*
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 
 * Observations
 * 1.) first and last col is always 1
 * 2.) cell is sum of two elements from last row
 * 3.) ith row contains i cols
 * 4.)
 * 
 * For a particular row(suppose 4th index row)
 * 
 * cols 4C0 4C1 4C2 4C3 4C4
 *      1   4   6   4   1
 *      
 *   4C2  = 4*3/1*2 (2 elements above and 2 down) -> trick for nCr
 *   4C3  = 4*3*2/1*2*3(3 elements above and 3 down)
 *   
 *   we can see that col index=3 and row=4
 *   we multipled the ans(4C2) with (r-c+1) and divided with c
 *   
 *   So from one cell to another we can compute in O(1)
 * 
 * Value at r,c  is r-1 C c-1 -> O(n) bcs factorial takes O(n)
 * 
 * 
 * 
 * case                     TC          SC
 * print all cell           n2          n2
 * cal once cell            n           1
 * cal nth row              n           n   
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
