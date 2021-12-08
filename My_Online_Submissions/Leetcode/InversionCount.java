
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Arrays;

public class InversionCount
{
    public static int merge_and_count(int arr[],int low,int mid,int high)
    {
        int count = 0;
        
        int left[]  = new int[mid-low+1];
        int right[] = new int[high-mid];
        
        left  = Arrays.copyOfRange(arr,low,mid+1);      // mid is included here  [start,end]
        right = Arrays.copyOfRange(arr, mid+1, high+1); // mid is excluded here
        
        int i = 0;
        int j = 0;
        int k = low;
        
        // Left is already sorted
        // right is already sorted
        // merging them
        while(i<left.length && j<right.length)
        {
            if(left[i]<=right[j])
            {
                arr[k++] = left[i++];
            }
            else
            {
                arr[k++] = right[j++];
                // j doesn't matter since elements satisfying will be from curr pos(low+i) to mid
                count = count + (mid+1) - (low+i);  
            }
        }
        
        while(i<left.length)    arr[k++] = left[i++];
        while(j<right.length)   arr[k++] = right[j++];
        
        return count;

    }
    public static int mergeSortAndCountHelper(int arr[],int low,int high)
    {
        // put equality here bcs mid is passed in left not mid-1, otherwise infinite recursion
        if(low>=high)   return 0;
        
        int mid = low + (high-low)/2;
        
        int ans = 0;
        
        // include mid here bcs we want [low,mid] to be sorted
        ans+= mergeSortAndCountHelper(arr,low,mid);     
        ans+= mergeSortAndCountHelper(arr,mid+1,high);
        
        // count inversions while sorting-> sorting is necessary.
        // swaps reduces due to sorting
        ans+= merge_and_count(arr,low,mid,high);
        
        return ans;
        
    }
    public static int mergeSortAndCount(int arr[])
    {
        return mergeSortAndCountHelper(arr,0,arr.length-1);
    }
    public static void main(String[] a)
    {
        int[] arr = { 1, 20, 6, 4, 5 };
        
        System.out.println(mergeSortAndCount(arr));
    }
    
}
