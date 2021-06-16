/****
 * A number can be broken into different contiguous sub-subsequence parts. 
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
 * And this number is a COLORFUL number, since product of every digit of a 
 * contiguous subsequence is different
 *  
*/

#include<string.h>
#include<stdio.h>

#define OUT            printf
#define PRIME_NUMBER   100003

typedef struct NODE
{
    int key;
    struct NODE* next;
}node;

node db_base[PRIME_NUMBER];
int  db_index;

node* hash_table[PRIME_NUMBER];

int colourful_number;

node* get_node(int k)
{
    // malloc gives runtime error as memory of heap is filled
    node* newnode = &db_base[db_index++];       //malloc(sizeof(node));
    newnode->key=k;
    newnode->next = NULL;
    return newnode;
}

void init()
{
    colourful_number = 1;
    int i;
    for(i=0;i<PRIME_NUMBER;i++)
    {
        hash_table[i] = NULL;
    }
    db_index = 0;
}

void store_product(char input[], int s, int e)
{
    long long product = 1;
    int digit;
    
    for(;s<=e;s++)
    {
        digit = input[s]-'0';
        product = product*digit;
    }
    
    if(hash_table[product] == NULL)
    {
        node* newnode = get_node(product);
        hash_table[product] = newnode;
    }
    else
    {
        node* iter = hash_table[product];
        while(iter!=NULL)
        {
            if(iter->key == product)
            {
                colourful_number = 0;
                break;
            }
            iter = iter->next;
        }
    }
}

void generate_subarrays(char input[], int n)
{
    int start_index = 0;        // start of current subarray
    int end_index   = 0;
    int sub_arr_len = 1;        // generate subarrays of length 1 to n

    for(sub_arr_len = 1; sub_arr_len<=n; sub_arr_len++)
    {
        start_index = 0;
        end_index   = n-sub_arr_len;

        while(start_index<=end_index)
        {
            store_product(input,start_index,start_index+sub_arr_len-1);
            start_index = start_index+1;

            if((colourful_number == 0))
            {
                return;
            }
        }
    }
}
 
void is_colourful_number(int N) {

    if(N==0)    return ;
    
    init();
    int  len = 0;
    char inp_string[256];
    len = sprintf(inp_string,"%d",N);
    generate_subarrays(inp_string,len);
    
}


int main()
{
    init();
    int N = 3245;
    is_colourful_number(N);
    if(colourful_number == 1)    OUT("Yes\n");
    else                         OUT("No\n");
}