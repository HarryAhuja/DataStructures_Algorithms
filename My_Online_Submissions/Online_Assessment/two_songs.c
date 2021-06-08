/****
 * Question: Given a sorted array and value X. Find two longest songs
 *           satisfy these conditions
 *           1.) each songs should not be same object
 *           2.) if two songs durations are equal, first put lower index
 *           3.) if multiple pairs, then take pair with longest song
 */ 

#include <stdint.h>
#include <stdio.h>
#include <string.h>
#define OUT     printf

typedef struct PAIR
{
    int first_song;
    int second_song;
}pair;

pair db[1000];
int db_index = 0;

void init()
{
    int i;
    for(i = 0;i<=db_index;i++)
    {
        db[i].first_song = -1;
        db[i].first_song = -1;
    }
    db_index=0;
}

void find_two_songs(int *input, int n, int x)
{
    int start            = 0;
    int end              = n-1;
    pair result          = {-1,-1};          // Initialse index with -1
    uint8_t result_found = 0;

    while(start<end)
    {
        if(input[start]+input[end]==x)
        {
            if(0 == result_found)
            {
                result.first_song  = start;
                result.second_song = end;
                result_found       = 1;
            }

            // Storing all pairs in db
            db[db_index].first_song  = start;
            db[db_index].second_song = end;
            db_index++;

            start++;               //Either do start++ or end--, both will work
        }
        else if(input[start]+input[end]<x)
        {
            start++;
        }
        else
        {
            end--;
        }
    }

    int i;
    for(i = 0;i<db_index;i++)
    {
        OUT("[Index:%d] [First_Song:%d] [Second_Song:%d]\n",
             i,
             input[db[i].first_song],
             input[db[i].second_song]);
    }

    OUT("Result %d %d\n",input[result.first_song],input[result.second_song]);
}

int main()
{
    int x       = 60;
    int input[] = {1,10,20,30,30,40,45,50,70};
    int n       = sizeof(input)/sizeof(input[0]);

    init();
    find_two_songs(input,n,x);
}