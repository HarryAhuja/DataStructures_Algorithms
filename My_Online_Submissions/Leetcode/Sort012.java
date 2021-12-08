/*
 * 4 regions
 * 
 * 0 to j-1 -> 0
 * j to i-1 -> 1
 * i to k   -> unknown
 * k+1 to e -> 2
 * 
 * why i++ is not done when 2 is arr[i]==2? why only k-- is done
 * since we have analysed only arr[i] which is 2,we can swap it in 2's region with
 * guarantee but since we have not analysed the element which comes after swapping at
 * i. It can be 0/1/2 and we have to take action differently based on that-> we can't
 * skip that element without analysing
 * 
 * 
 * Why i++ and j++  is done when 0 is seen?
 * we can increment that counter where we are sure about the value
 * after swapping, j will get guaranteed 0 bcs we have seen 0 at i
 * Now from 0 to j-1 -> zeroes are there -> so increment j++
 * 
 * After swapping , ith index will contain guarateed 1. Why?
 * Bcs j to i-1 always contain 1-> this element also holds good for 
 * region -> already analysed-> increment i
 * 
 * when is i incremented -> when its get 1 -> why bcs j to i-1 is always 1 -> he needs 1 at his left
 * when is j incremented -> when its get 0 -> why bcs 0 to j-1 is always 0 -> he needs 0 at his left
 * when is k decremented -> when its get 2 -> why bcs k+1 to end is always 2 -> he needs 2 at his right
 * 
 * In any iteration, one unknown is reduced. Whether bcs of k-- or i++
 * 
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class Sort012 {
    public  void swap(int inp[], int x,int y)
    {
        int temp = inp[x];
        inp[x]   = inp[y];
        inp[y]   = temp;
    }
    public void sortColors(int[] inp) {
        int n = inp.length;
        
        if(n==0)    return;
        
        int i = 0, j = 0, k = n-1;
        
        while(i<=k)
        {
            if(inp[i] == 0)
            {
                swap(inp,i,j);
                i++;
                j++;
            }
            else if(inp[i] == 1)
            {
                i++;
            }
            else if(inp[i] == 2)
            {
                swap(inp,i,k);
                k--;
            }
        }
    }
}
