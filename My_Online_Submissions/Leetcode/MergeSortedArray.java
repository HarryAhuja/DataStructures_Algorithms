package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class MergeSortedArray {
    
    public static void merge_sorted_arrays(int nums1[], int m, int nums2[], int n)
    {
        int j = n-1;
        int i = m-1;
        int k = m+n-1;
        
        while(i>=0 && j>=0)
        {
            if(nums1[i]<=nums2[j])
            {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
            else if(nums1[i]>nums2[j])
            {
                nums1[k] = nums1[i];
                i--;
                k--;
            }
        }
        
        while(i>=0)
        {
            nums1[k] = nums1[i];
            i--;
            k--;
        }
        
        while(j>=0)
        {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {

        int nums1[] = {1,2,3,0,0,0}, m = 3, nums2[] = {2,5,6}, n = 3;
        
        merge_sorted_arrays(nums1,m,nums2,n);

        for(int i=0;i<m+n;i++)
        {
            System.out.print(nums1[i]+" ");
        }
    }

}
