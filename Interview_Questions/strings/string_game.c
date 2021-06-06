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
 * Output = yes
 * a is shifted 3 times to become d
 * b is shifted 2 times to become d
 * c is shifted 1 times to become d
 * 
 * Sample Input2
 * Source = "axc", target= "dad", k=3
 * Output = No as a to d and x to a both takes 3 units
 * 
 * Sample Input3
 * Source = "axc", target= "dad", k=29
 * Output = Yes as a to d and x to a both takes 3(or3+26=29) units 
 * 
 * Sample Input4
 * Source = "axa", target= "dad", k=29
 * Output = no as first a to d and x to a took 3(or3+26=29) units. 
 *          Last a to d has no choice 
 * 
 * Sample Input5
 * Source = "axa", target= "dad", k=55
 * Output = Yes as first a to d and x to a took 3(or3+26=29) units. 
 *          Last a to d took 3+26+26=55 units
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
#define MAX_LENGTH          1000

// Make it MAX_LEN to store circular rotated values also
// 26 will limit the circular rotation 
uint8_t visited[MAX_LENGTH];            

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

    uint16_t i           = 0;      // Iterator
    uint16_t t           = 0;      // target char offset
    uint16_t s           = 0;      // Source char offset
    int      diff        = 0;      // target and source char offset diff
    uint8_t  place_avail = 0;      // flga place availability in visited array 
    
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
            return;
        }

        place_avail = 0;
        while(diff<=k)
        {
            // As one shift out of 1 to k can be used at most once
            if(0 == visited[diff])
            {
                visited[diff] = 1;
                place_avail   = 1;
                break;                              
            }
            // Check if place is available by circularly rotating it
            else
            {
                
                diff = diff + MAX_ALPHABET_SIZE;
            }
        }

        if(0 == place_avail)
        {
            OUT("#RESULT [No]\n");
            return;
        }
        
    }

    OUT("#RESULT [Yes]\n");
    
}


int main()
{
    char source[] = "axa";
    char target[] = "dad";
    int k         = 55;

    init();
    is_conversion_possible(source,target,k);
}