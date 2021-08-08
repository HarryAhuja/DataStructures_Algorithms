package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class SortColours {

    public static void swap(int inp[], int x,int y)
    {
        int temp = inp[x];
        inp[x]   = inp[y];
        inp[y]   = temp;
    }
    public static void sort_colours(int inp[])
    {
        int n = inp.length;
        
        if(n==0)    return;
        
        int i = 0, j = 0, k = n-1;
        
        // = is important. Single element should be in
        // correct position
        // [2,0,1]
        while(j<=k)
        {
            if(inp[j] == 0)
            {
                swap(inp,i,j);
                
                // Here we ith element is already processed so we
                // can do i++ bcs we can't have array like [0,0,0,1,2,0(j)]
                // bcs 2 will be already taken care. So it will be like this
                // [0,0,0,1,1,0(j)]. It will be 1 only bcs if 0 was there
                // instead of 2, it would have been taken care and placed 
                // before i
                i++;            // [0:i-1] contains 0 section
                j++;            // Element is processed succesfully
            }
            else if(inp[j] == 1)
            {
                j++;            // Take care of 0 and 2 only
            }
            else if(inp[j] == 2)
            {
                swap(inp,j,k);
                k--;            //[k+1:n-1] contains 2 section
                // No need for j++, since any char will replace
                // 2. So that replaced char should be processed
                // again for correct position
                // [0,0,1,2,0,0,0]
                // 2 will be replaced with 0
                // So [0,0,1,0,0,0,2]
                // Now this 0 should be processed again for correct
                // position
            }
        }
    }
    
    public static void main(String[] args) {
        
        int inp[] = {2,0,1};
        
        sort_colours(inp);
        
        for(int i=0;i<inp.length;i++)
            System.out.println(inp[i]+" ");

    }

}
