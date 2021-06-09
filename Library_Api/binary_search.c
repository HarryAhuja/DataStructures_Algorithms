/******
 * Tips
 * mid = (low+high)/2 or low + (high-low)/2
 * when index goes out of bounds, in both cases r<l
 * To know if index goes out of bounds on left side, r will become <0
 * To know if index goes out of bounds on right side,l will become >=N
 * but second case needs N to be a parameter. Don't use high bcs its variable
 */ 

#include <stdint.h>
#include <stdio.h>
#include <string.h>
#define OUT     printf

int binary_search(int *input, int low, int high,int n, int value)
{
    if(high<low) return -1;

    int mid = (low+high)/2;     // or low + (high-low)/2
    if(value == input[mid]) return mid;

    if(value < input[mid])  return binary_search(input,low,mid-1,n,value);
    else                    return binary_search(input,mid+1,high,n,value);
}

int main()
{
    int input[] = {1,4,6,8,10,15,20,21};
    int value   = 2;
    int n       = sizeof(input)/sizeof(input[0]);
    int index   = -1;

    index = binary_search(input,0,n-1,n,value);
    OUT("Index is %d and value is %d\n",index,input[index]);
}