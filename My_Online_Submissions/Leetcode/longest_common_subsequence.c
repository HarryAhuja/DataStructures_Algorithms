/************ 
 * Given two strings text1 and text2, return the length of their longest
 * common subsequence. If there is no common subsequence, return 0.
 *
 * Input: text1 = "abcde", text2 = "ace" 
 * Output: 3  
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * 
 * Constraints
 * 1<=len<=1000
 * Only lower english chars
 * 
 * TIP
 * sizeof() operator includes null char also
 * strlen doesn't take null char
 * use strlen in case of strings present in string.h
 */

#include <stdint.h>
#include <stdio.h>
#include <string.h>

#define OUT                 printf
#define MAX_LENGTH          1000

uint32_t dp_table[MAX_LENGTH+1][MAX_LENGTH+1];

void print_dp_table(int m,int n)
{
    int i = 0;
    int j = 0;
    for(i=0;i<=m;i++)
    {
        for(j=0;j<=n;j++)
        {
            OUT("%d ",dp_table[i][j]);
        }
        OUT("\n");
    }
}

uint32_t find_max(uint32_t a, uint32_t b)
{
    return a>=b?a:b;
}

void init()
{
    memset(dp_table,0,sizeof(dp_table));
}

uint32_t find_lcs(char *A,char *B, int m, int n)
{
    uint32_t row    = 0;
    uint32_t col    = 0;

    for(row = 1; row<=m; row++)
    {
        for (col = 1; col <=n; col++)
        {
            if(A[row-1] != B[col-1])
            {
                dp_table[row][col] = find_max(dp_table[row-1][col],dp_table[row][col-1]);
            }
            else
            {
                dp_table[row][col] = dp_table[row-1][col-1] + 1;
            }
        }
    }

    return dp_table[m][n];
}


int main()
{
    char     A[] = "abcde";
    char     B[] = "ace";
    int      m   = strlen(A);
    int      n   = strlen(B);
    uint32_t max = 0;

    init();
    max = find_lcs(A,B,m,n);

    OUT("Max Lengh is %d\n",max);
    print_dp_table(m,n);
}
    
