/*
 * [3,2,4]
 * 
 * 1.) 3 is inserted first
 * 2.) when 2 is being inserted
 *     2 = I1(trying to insert)
 *     3 = I2(already inserted)
 *     
 *     2.compareTo(3) -> since 2 should come first -> compareTo() should negative
 *     if(i1<i2)    return -1;
 */


package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Arrays;

class Pair implements Comparable<Pair>
{
    public int value;
    public int index;
    
    public Pair(int value,int index)
    {
        this.value = value;
        this.index = index;
    }
    
    @Override
    public int compareTo(Pair i2)
    {
        // In ascending order, inserting value(i
        if(this.value>i2.value)         return 1;       
        else if(this.value<i2.value)    return -1;
        else                            return 0;
        
        //return Integer.valueOf(this.value).compareTo(i2.value);
    }
}

public class TwoSum {

    public static int[] find_two_sum(int inp[], int target)
    {
        int n        = inp.length;
        int result[] = new int[2];
        result[0]    = -1;
        result[1]    = -1;
        
        Pair pair_array[] = new Pair[n];
        
        for(int i=0;i<n;i++)
        {
            pair_array[i] = new Pair(inp[i],i);
        }

        Arrays.sort(pair_array);
        
        int low  = 0;
        int high = inp.length-1;
        
        while(low<high)
        {
            if(pair_array[low].value == target-pair_array[high].value)        // Prevent Overflow 
            {
                result[0] = pair_array[low].index;
                result[1] = pair_array[high].index;
                low++;
                high--;
                break;
            }
            else if(pair_array[low].value < target-pair_array[high].value)
            {
                low++;
            }
            else
            {
                high--;
            }
        }
        
        return result;
        
    }
    public static void main(String[] args) {
        
        int inp[] = {3,2,4};
        int tar   = 6;
        
        int result[] = find_two_sum(inp,tar);
        
        for(int i=0;i<result.length;i++)
        {
            System.out.print(result[i]+" ");
        }

    }

}
