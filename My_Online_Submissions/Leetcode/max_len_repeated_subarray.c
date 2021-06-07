/************
 * Alternative Name: Longest common substring
 * 
 * Question : Given two integer arrays nums1 and nums2, 
 * return the maximum length of a subarray that appears in both arrays.
 *
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * Output: 3
 * Explanation: The repeated subarray with maximum length is [3,2,1].
 * 
 * Constraints
 * 1<=len<=1000
 * 0<=array[i]<=100
 */

#include <stdint.h>
#include <stdio.h>
#include <string.h>

#define OUT                 printf
#define MAX_LENGTH          1000

uint32_t dp_table[MAX_LENGTH+1][MAX_LENGTH+1];

uint32_t find_max(uint32_t a, uint32_t b)
{
    return a>=b?a:b;
}

void init()
{
    memset(dp_table,0,sizeof(dp_table));
}

uint32_t find_max_repeated(int *A,int *B, int m, int n)
{
    uint32_t row    = 0;
    uint32_t col    = 0;
    uint32_t result = 0;

    for(row = 1; row<=m; row++)
    {
        for (col = 1; col <=n; col++)
        {
            if(A[row-1] != B[col-1])
            {
                dp_table[row][col] = 0;
            }
            else
            {
                dp_table[row][col] = dp_table[row-1][col-1] + 1;
            }

            result = find_max(result,dp_table[row][col]);
        }
    }

    return result;
}


int main()
{
    int      A[] = {0,0,0,0,0};//{1,2,3,2,1};
    int      B[] = {0,0,0,0,0};//{3,2,1,4,7};
    int      m   = sizeof(A)/sizeof(A[0]);
    int      n   = sizeof(B)/sizeof(B[0]);
    uint32_t max = 0;

    init();
    max = find_max_repeated(A,B,m,n);

    OUT("Max Lengh is %d\n",max);
}
    
