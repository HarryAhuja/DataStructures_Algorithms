/***
 * Tips
 * There is no overlapping subinterval
 * if 0 appears, then new set will start from next one
 * 
 * Another solution
 * Just start new set when you see 0 in sliding window
 */ 

#include <stdint.h>
#include <stdio.h>
#include <string.h>

#define OUT     printf

int max(int a, int b)
{
    return a>=b?a:b;
}

void find_consecutive_ones(int *input, int n)
{
    if(n==0)
    {
        OUT("Error");
    }
    int result   = 0;
    int sum      = 0;
    int prev_sum = 0;
    int iter     = 0;
    int start    = 0;

    for(iter = 0;iter<n;iter++)
    {
        sum = sum + input[iter];
        
        if(prev_sum!=sum)
        {
            result = max(result,iter-start+1);
        }
        else
        {
            sum = 0;
            start=iter+1;
        }
        prev_sum = sum;
    }
    OUT("Result [%d]\n",result);
}

int main()
{
    int inp_1[] = {1,1,0,1,1,1};
    int inp_2[] = {1,0,1,1,0,1};
    int inp_3[] = {0,0,0,0,0};
    int inp_4[] = {1,1,1,1,1};
    int inp_5[] = {0,0,1,1,1};
    int inp_6[] = {0,0,1,1,0};
    int n     = sizeof(inp_6)/sizeof(inp_6[0]);

    find_consecutive_ones(inp_6,n);
}

