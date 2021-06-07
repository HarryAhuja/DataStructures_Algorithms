/*****
 * Generate all subarrays
 * Array=[1, 2, 3, 4]
 * Subarrays: (1), (2), (3), (4), (1,2), (2,3), (3,4), (1,2,3), (2,3,4) and (1,2,3,4)
 * Total = n*(n+1)/2 non empty
 */
#include <stdint.h>
#include <stdio.h>
#include <string.h>
#define OUT     printf

void print_array(int input[], int s, int e)
{
    for(;s<=e;s++)
    {
        OUT("%d ",input[s]);
    }
    OUT("\n");
}

void generate_subarrays(int input[], int n)
{
    int start_index = 0;        // start of current subarray
    int end_index   = 0;
    int sub_arr_len = 1;        // generate subarrays of length 1 to n

    for(sub_arr_len = 1; sub_arr_len<=n; sub_arr_len++)
    {
        OUT("Subarrays of length=%d\n",sub_arr_len);
        start_index = 0;
        end_index   = n-sub_arr_len;

        while(start_index<=end_index)
        {
            print_array(input,start_index,start_index+sub_arr_len-1);
            start_index = start_index+1;
        }
        OUT("\n");
    }
}

int main()
{
    int input[]= {1,2,3,4};
    int n      = sizeof(input)/sizeof(input[0]);

    generate_subarrays(input,n);
}