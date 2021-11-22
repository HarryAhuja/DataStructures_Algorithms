/*
 * Non overlapping cases
 *           S     D
 *     D     -------    S
 * -----                --------
 * 
 * starting of i is less than departure of i-1
 * 
 * Overlapping cases
 * 
 *              -----------
 *       ---------
 *            ------------------
 *                      ------------
 *  Ans would be max numbers of train overlapped in given time
 *  
 *  approach
 *  
 *  the only thing matters is : is train arriving or going at any instant in the day
 *  which train doesn't matter
 *  
 *  sort both arrays
 *  
 *  arr = {50,120,200,550...}
 *  dep = {500,550......}
 *  
 *  0th arrival and dep maybe of same/diff train: doesn;t matter
 *  
 *  first train in a day will depart at 500 leaving one station empty but before that time
 *  three trains already arrived(doesn't matter which trains)-> so they will take 3 stations
 *  
 *  when 500 departs that train can be {50,500},{120,500},{200,500} or other(this can't 
 *  bcs arrival<dep) but it doesn't
 *  matter since we only know that departing that train at that time means one station is now
 *  empty
 *  
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Arrays;

public class MinimumPlatforms {

    public static int max(int a,int b)
    {
        return a>b?a:b;
    }
    public static int minimum_platforms(int arr[],int dep[])
    {
        int n = arr.length;
        if(n==0)    return 0;
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i=0,j=0;
        
        int count = 0;
        int ans   = Integer.MIN_VALUE;
        
        while(i<n && j<n)
        {
            //At any given instance of time, same platform can not be used for both 
            //departure of a train and arrival of another train. In such cases, we 
            //need different platforms.
            if(arr[i]<=dep[j])
            {
                count++;
                ans = max(ans,count);
                i++;
            }
            else
            {
                count--;
                j++;
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {900, 1100, 1235};
        int dep[] = {1000, 1200, 1240};
        
        System.out.println(minimum_platforms(arr,dep));
    }

}
