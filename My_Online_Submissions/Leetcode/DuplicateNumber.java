package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class DuplicateNumber {

    public static int count_elements(int inp[], int target)
    {
        int count = 0;
        
        for(int i=0;i<inp.length;i++)
        {
            if(inp[i]<=target) count++;
        }
        
        return count;
    }
    public static int find_duplicate_helper(int inp[], int low, int high)
    {        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            int count = count_elements(inp,mid);
            
            if(count <= mid)    low  = mid+1;
            else                high = mid-1;
        }
        
        return low;
    }
    public static int find_duplicate(int inp[])
    {
        int n = inp.length;
        
        if(n==0 || n==1)    return -1;
        
        // Bcs we are doing index space search not value space search
        // So pass 1 and n. Array indexing is not anywhere
        // So its safe
        return find_duplicate_helper(inp,1,n);      
    }
    public static void main(String[] args) {

        int inp[] = {1,3,2,4,4};
        
        System.out.println(find_duplicate(inp));

    }

}
