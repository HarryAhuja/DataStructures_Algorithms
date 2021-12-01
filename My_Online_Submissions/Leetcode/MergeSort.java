package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class MergeSort {

    public static void merge(int arr[],int l,int mid, int r)
    {
        
        
        // In case of even n, both will contain equal elements
        // in case of odd n, left will contain one more element(compulsory),
        // otherwise in case of even elements left will fail
        // mid-l+1 is neccessary
        int n1  =   mid-l+1;
        int n2  =   r-mid;
        
        /*
         * Why do we need extra space
         * 1    5   9   10          2   3   4   7
         * 
         * Suppose this is original array(sub ranges sorted)
         * when i=1 and j=0
         * k =  1
         * 
         * as 2<5, will replace 5 and 5 will replace 2
         * 
         * 1    2   9   10          5   3   4   7
         * i = 1, j=1
         * k = 2
         * but this has disturbed the property of sorted sub ranges
         * and now 5 should be compared again with 9 but we have incremented the index
         * of j to 3
         * 
         * So main property while merging using 2 pointer that, those two arrays should
         * not change. So we need extra space
         */
        
        int left_arr[]  = new int[n1];   //elements from index=0 to mid
        int right_arr[] = new int[n2];  // elements from index=mid+1 to r
       
        /*
         *  At this point of time subarrays ranges in original arrays are sorted individually
         *  So we can copy them into sub arrays and then copy back to original array
         *  after merging
         */
       
        for(int i=0;i<n1;i++)
        {
            left_arr[i] = arr[l+i];
        }
        for(int j=0;j<n2;j++)
        {
            right_arr[j] = arr[mid+j+1];
        }
        
        int i = 0;
        int l_length = left_arr.length;
        int j = 0;
        int r_length = right_arr.length;
        int k = l;  // write in original array from left to right
        
        while(i<l_length && j<r_length)
        {
            // equality for stableness
            // pick element from left array first
            if(left_arr[i]<=right_arr[j])
                arr[k++] = left_arr[i++];
            else
                arr[k++] = right_arr[j++];
        }
        
        while(i<l_length)
        {
            arr[k++] = left_arr[i++];
        }
        
        while(j<r_length)
        {
            arr[k++] = right_arr[j++];
        }
    }
    public static void merge_sort(int arr[],int l, int r)
    {
        // if out of range or 1 element left
        if(l>=r)    return;
        
        int mid = l + (r-l)/2;
        
        /*
         * Passing l,mid+1 and mid,r will lead to stack overflow
         * Bcs when there are two elements left
         * mid = first element always
         * 
         * merge_sort(arr,l,mid-1)-> sort 0 elements
         * merge_sort(arr,mid,r) -> sort 2 elements
         * 
         * so call to sort 2 elements will keep on doing
         * 
         * But when 
         * merge_sort(arr,l,mid); -> sort first element
         * merge_sort(arr,mid+1,r); -> sort second element
         */
        merge_sort(arr,l,mid);
        merge_sort(arr,mid+1,r);
        
        merge(arr,l,mid,r);
    }
    public static void main(String[] args) {
        int arr[] = {5,2,3,1};
        
        merge_sort(arr,0,arr.length-1);
        
        for(int i:arr)
            System.out.println(i);
        
        

    }

}
