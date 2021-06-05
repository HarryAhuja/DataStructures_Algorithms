/**********************************
 * Question
 * Given two strings S and T of same length and integer k
 * 
 * 1) For each x from 1 to k, any index from S is picked and char at that index
 *    is shifted right x units. Shift is circular that if z is shifted 1 unit,
 *    it becomes a
 * 2) Any value x from 1 to k can be picked at most once
 * 
 * Check if T can be made by this operations from S
 * 
 * Output-> Yes or No
 * 
 * Constraints
 * 1) 1<=len<10^3
 * 2) 1<=k<=len
 * 3) time=1sec,memory=256mb,source limit=1mb
 * 
 * Sample Input1
 * Source = "abc", target= "ddd", k=3
 * Output=yes
 * a is shifted 3 times to become d
 * b is shifted 2 times to become d
 * c is shifted 1 times to become d
 * 
 * Tips
 * -> char can shift towards positive side or negative side to reach target
 *    negative side = make it positive by circular shift that is modulus
 * -> Check if shift >k, if yes then its not possible
 * -> Because each char at ith place is bound to be changed in target at ith
 *    pos only, that is why we can use visited array 
 *    If ith can be changed to any char in target, then all posibilities need
 *    to be taken care
 **********************************/

#include <stdint.h>
#include <stdio.h>
#include <string.h>

#define MAX_ALPHABET_SIZE   26
#define OUT                 printf

uint8_t visited[26];

void init()
{
    memset(visited,0,sizeof(visited));
}

void is_conversion_possible(char source[], char target[], int k)
{
    uint16_t source_size = sizeof(source)/sizeof(source[0]);
    uint16_t target_size = sizeof(target)/sizeof(target[0]);

    if(source_size!=target_size)
    {
        OUT("#ERROR [source_size!=target_size]\n");
        return;
    }

    uint16_t i    = 0;      // Iterator
    uint16_t t    = 0;      // target char offset
    uint16_t s    = 0;      // Source char offset
    int      diff = 0;      // target and source char offset diff
    
    for (i = 0; source[i]!='\0'; i++)
    {
        diff = target[i]-source[i];

        if(diff<0)
        {
            diff= (diff+MAX_ALPHABET_SIZE)%MAX_ALPHABET_SIZE; // Make it pos
        }
        
        if(diff>k)
        {
            OUT("#ERROR [diff is out of range]\n");
        }

        // As one shift out of 1 to k can be used at most once
        if(visited[diff]==0)
        {
            visited[diff] = 1;                              
        }
        else
        {
            OUT("#RESULT [No]\n");
            return;
        }
    }

    OUT("#RESULT [Yes]\n");
    
}


int main()
{
    char source[] = "axc";
    char target[] = "dad";
    int k         = 3;

    init();
    is_conversion_possible(source,target,k);
}