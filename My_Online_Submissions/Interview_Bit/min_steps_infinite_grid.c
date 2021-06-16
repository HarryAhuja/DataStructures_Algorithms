/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * @input B : Integer array
 * @input n2 : Integer array's ( B ) length
 * 
 * @Output Integer
 */
#include<stdio.h>
#include<math.h>

#define OUT             printf
#define INT_MAX         1000000

int max(int a,int b)
{
    return a>=b?a:b;
}

int coverPoints(int* A, int n1, int* B, int n2)
{
    if(n1!=n2)  return 0;
    
    int ans = 0;
    int i   = 0;

    for(i=0;i<n1-1;i++)
    {
        int delta_x = abs(A[i]-A[i+1]);
        int delta_y = abs(B[i]-B[i+1]);
        ans = ans + max(delta_x,delta_y);
    }
    return ans;
}

int main()
{
    int A[]={0,1,1};
    int B[]={0,1,2};
    int n = sizeof(A)/sizeof(A[0]);

    int ans = coverPoints(A,n,B,n);
    OUT("Minimum steps are :%d\n",ans);
}