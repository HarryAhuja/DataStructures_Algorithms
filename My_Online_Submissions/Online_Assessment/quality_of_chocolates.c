/*****
 * Question 
 * N = no of chocolates 
 * A[i] : Sweetness of chocolate
 * B[i] : lifetime of chocolate
 * Q    : queries with X and Y
 * 
 * Find no of cholcates having A[i] and B[i]> X and Y respectively
 * 
 * Constraints:
 * 1<N,Q<2*10^5
 * 1<=A[i]<=10^9
 * 
 * Tips
 * Use binary search after sorting
 * Return the exact index from which counting will start
 */

#include <stdint.h>
#include <stdio.h>
#include <string.h>

#define OUT     printf

void merge(int arr[], int l, int m, int r)
{
    int i, j, k;
    int n1 = m - l + 1;
    int n2 = r - m;
 
    /* create temp arrays */
    int L[n1], R[n2];
 
    /* Copy data to temp arrays L[] and R[] */
    for (i = 0; i < n1; i++)
        L[i] = arr[l + i];
    for (j = 0; j < n2; j++)
        R[j] = arr[m + 1 + j];
 
    /* Merge the temp arrays back into arr[l..r]*/
    i = 0; // Initial index of first subarray
    j = 0; // Initial index of second subarray
    k = l; // Initial index of merged subarray
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        }
        else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
 
    /* Copy the remaining elements of L[], if there
    are any */
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
 
    /* Copy the remaining elements of R[], if there
    are any */
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}
 
/* l is for left index and r is right index of the
sub-array of arr to be sorted */
void mergeSort(int arr[], int l, int r)
{
    if (l < r) {
        // Same as (l+r)/2, but avoids overflow for
        // large l and h
        int m = l + (r - l) / 2;
 
        // Sort first and second halves
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
 
        merge(arr, l, m, r);
    }
}
 


void sort(int A[], int N)
{
    mergeSort(A,0,N-1);
}

int max(int A,int B)
{
    return A>=B?A:B;
}

int find_index(int *arr, int l, int r, int N,int val)
{
    // All these return values are decided acc to how will be used in main 

    if(r<0)     return 0;       // If all elements are greater
    if(l>=N)    return N;       // If none of the element is greater

    if(l<=r)
    {
        int mid = (l+r)/2;

        if(arr[mid]==val)
        {
            // We need greater elements, no greater or equal. Exclude arr[mid]
            return mid+1;       
        }   
        if(((mid-1>=0) && arr[mid-1]<=val) && arr[mid]>val)
        {
            // if mid-1 is equal, then exlude = value, so return mid
            // no need of equality in arr[mid]>val since its already been checked
            return mid;
        }

        if(((mid+1<=r) && arr[mid+1]>val) && arr[mid]<val)
        {
            // if mid+1 is equal, then need to return mid+2
            // No need to stretch it, otherwise more index checking is needed
            // instead call right side, it will be taken care
            // If mid+1 is not equal but val is in range of both then mid+1
            return mid+1;
        }

        if(val<arr[mid])    return find_index(arr,l,mid-1,N,val);
        else                return find_index(arr,mid+1,r,N,val);
    }

    return -1;         
}

void find_chocolates(int *A, int *B, int N, int *X, int *Y, int Q)
{
    int result = 0;
    int q      = 0;       // Query index
    int sweetness_index = 0;
    int lifetime_index  = 0;

    if(0 == N)
    {
        OUT("#Error [Length of input is 0]");
        return;
    }
    
    sort(A,N);            // Sort for binary search
    sort(B,N);            // Sort for binary search

    for(q=0;q<Q;q++)
    {
        result = 0;

        sweetness_index = find_index(A,0,Q-1,N,X[q]);
        if(-1 != sweetness_index) 
        {
            lifetime_index  = find_index(B,0,Q-1,N,Y[q]);

            if(-1!= lifetime_index)
            {
                result = max(sweetness_index,lifetime_index);
                result = N-result;
            }
        }

        OUT("Sweetness[%d] Lifetime[%d]-->Chocolates[%d]\n",
             X[q],
             Y[q],
             result);
    }
}

int main()
{
    int N   = 5;
    int A[] = {16,11,10,20,18};
    int B[] = {11,9,2,2,4};
    int Q   = 5;
    int X[] = {3,4,9,4,8};
    int Y[] = {20,5,1,6,4};
    
    find_chocolates(A,B,N,X,Y,Q);
}