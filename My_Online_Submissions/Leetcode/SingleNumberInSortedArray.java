/*
 *  Since every number appears twice except one, n will always be odd
 *  
 *  in a sorted space, first instance of any number will appear 
 *  at odd index and second instance on even index
 *  
 *  Suppose I am at first instance of mid
 *  so I will jump my mid to second instance always
 *  
 *  if(mid+1==mid)  mid++;
 *  
 *  now after this, if left half is sorted then mid-l(length of left half)
 *  would be even
 *  
 *  If its even that means left half is sorted
 *  Therefore go right
 *  
 *  0   1   2   3   4   5   6   7   8   
 *  10  10  11  11  12  12  13  14  14
 *  
 *  
 *  In this case we are already at second instance of 12. 
 *  So will check length of of left half-> since its odd that means 
 *  some number is appearing one time
 *  
 *  0   1   2   3   4   5   6   7   8
 *  10  10  11  12  12  13  13  14  14
 *  
 *  Here mid = 5. Second instance but left half is sorted-> go right
 *  0   1   2   3   4   5   6   7   8   9   10
 *  10  10  12  12  13  13  15  17  17  18  18
 *  
 *  How to reduce SS?
 *  
 *  since n is always odd->
 *  in case 1, mid = 12A
 *  If mid==12A, that means there are even elements in left-> go right
 *  
 *  if mid==12B, that means there are odd elements in left-> go left
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class SingleNumberInSortedArray
{
    public int singleNonDuplicate(int[] nums)
    {
        int low  = 0;
        int n    = nums.length;
        int high = n-1;
        
        while(low<high)
        {
            int mid = (low+high)/2;
            
            if(nums[mid] == nums[mid+1])    mid++;
            
            // left half is odd
            if((mid-low+1)%2==1) high = mid;
            else                 low  = mid+1;
        }
        
        return nums[low];
    }
}
