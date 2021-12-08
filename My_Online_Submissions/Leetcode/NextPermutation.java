/*
 *  4 3 2 1
 *  if numbers are in decreasing order, than we can't make next bigger permutation
 *  
 *  4 3 5 3
 *  From 5, numbers are in decreasing order-> so we can't make bigger from 5 3(from 5 onwards)
 *  (till decreasing order end)
 *  
 *  But 5 is breakpoint of decreasing order of 4 3 5 -> so 3 5 is in increasing order
 *  so we can make bigger permutation with it
 *  
 *  So question is if i have increasing seq a b c -> how it should be swapped to make
 *  only next permutation
 *  
 *  
 *  Example 13542
 *      5
 *    3   4
 *  1      2
 *  
 *  3 is the breakpoint? why bcs 5 4 2 is decreasing sequence-> any permutation of it
 *  will be less than it-> it will not serve our purpose
 *  
 *  Also
 *  1 3 5 -> I can't change(5) this prefix from right elements(4,2) bcs they are less than
 *  5. Same point
 *  1 3 -> If can change this prefix(3) with something greater from right side, then it will
 *  be greater than 13
 *  
 *  Suppose i changed to 1 2 ....-> all these sequences will be lesser than 1 3-> so i need 
 *  to swap with something greater
 *  
 *  Why to change 3 only, why not 1-> bcs if i change 1 to something greater than it will
 *  be greater than original but not will be next permutation-> order will be something diff
 *  
 *  Examples
 *  1 5 3 4 2-> 5(>3) has been replaced with 3
 *  1 4 5 3 2->4(>3) has been replaced with 4
 *  
 *  Which greater element from right should be replaced
 *  Least element from all the elements which are greater than 3 on its right should be replaced
 *  Total elements on right side of 3 = 5 4 2
 *  elements > 3  = 5 4
 *  Least element = 4
 *  bcs 14..5 will be lexographically nearer to original than 15..4
 *  So least element will be nearer
 *  
 *  Now i have taken care of
 *  1 3....-> 1 4....
 *  But on the right side of 4, elements are 5 3 2(decreasing order)
 *  But their permutation of 2 3 5 will be smallest and nearer
 *  so reverse them
 *  
 *  Algo
 *  1.) from right to left, find first index i for which arr[i]<arr[i+1]-> breakpoint
 *  2.) from right elements of i, find first index which is greater than >arr[i],
 *      bcs elements are in decreasing order on right, it will be least among all >arr[i]
 *  3.) swap i and index
 *  4.) reverse elements from i+1 to end
 *  
 *  If i from 1.) step is not found, skip 2 and 3 but do reverse(bcs we need sorted order)
 *  when not possible
 *  
 *  TC 5 1 1
 *     output should be 1 1 5
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class NextPermutation {
    public static void swap(int nums[],int a,int b)
    {
        nums[a] = nums[a]^nums[b];  // a = a^b
        nums[b] = nums[a]^nums[b];  // b = a^b = (a^b)^b = a;
        nums[a] = nums[a]^nums[b];  // a = a^b = (a^b)^a = b
    }
    public static void nextPermutation(int[] nums)
    {
        int n = nums.length;
        if(n==0 || n==1)    return;

        // at least two elements in array
        
        
        // Step 1: find i
        int i = n-2;
        for(;i>=0;i--)
        {
            // equality-> no-> TC 5 1 1
            if(nums[i]<nums[i+1])   break;
        }
        
        if(i!=-1)
        {
            // Step 2: find swapping element
            int index = i+1;
            
            // in case of duplicates we are find lower element than those.
            // so here it will break always
            for(int j=n-1;j>i;j--)
            {
                if(nums[j]>nums[i])
                {
                    index = j;
                    break;
                }
            }
            
            // Step3: swap
            swap(nums,index,i);
        }
            
        // Step 4: reverse
        int x = i+1;
        int y = n-1;
        while(x<y)
        {
            swap(nums,x,y);
            x++;
            y--;
        }
        
    }
    public static void main(String ar[])
    {
        int nums[] = {1,2,3};
        nextPermutation(nums);
    }
}
