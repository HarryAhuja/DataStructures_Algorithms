/****
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Constrains
 * len = 0 to 10^5
 * consist of english letters, digits, symbols and spaces
 * 
 * Tips
 * if length is not zero, then min ans is 1(single char is always non rep)
 * To check repetetion inside a string, use hashmap
 */ 

#include <stdint.h>
#include <stdio.h>
#include <string.h>

#define OUT         printf
#define MAX_CHARS   256

int last_index_seen[MAX_CHARS];

int max(int a, int b)
{
    return a>=b?a:b;
}

void init()
{
    int i = 0;
    for(i = 0; i<MAX_CHARS; i++)
    {
        last_index_seen[i] = -1;            // not visited[-1], index[0:N-1]
    }
}

int find_longest_substring(char *input)
{
    int n      = strlen(input);

    if(0 == n)  return 0;

    int i      = 0;             // temp iterator
    int iter   = 0;             // iterator, end of sliding window
    int start  = 0;             //  start of sliding window
    int result = 1;             //  result will be min 1 always

    while(iter<n)
    {
        if(-1 == last_index_seen[input[iter]])
        {
            // just increase the iter and update result
        }
        else
        {
            int temp = start;
            start = last_index_seen[input[iter]]+1;

            //remove all chars from start to new start
            for(i = temp;i<start;i++)
            {
                last_index_seen[input[i]] = -1;
            }

            
        }

        // new char from else case should also be updated
        last_index_seen[input[iter]] = iter;

        //Update results in both cases bcs
        //when else case is hit, there is chance it will be max result
        result = max(result,iter-start+1);

        // if iter++ is not done in else, then it will be in infinite loop
        iter++;                         
        
    }
    return result;
}

int main()
{
    char input_1[]="abcabcbb";
    char input_2[]="bbbbbbbb";
    char input_3[]="pwwkew";
    char input_4[]="";
    char input_5[]="dvdf";
    char input_6[]="abcabcbb";

    init();
    OUT("Max Length is %d\n",find_longest_substring(input_6));
    
}