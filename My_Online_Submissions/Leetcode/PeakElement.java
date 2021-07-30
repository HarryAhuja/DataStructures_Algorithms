package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class PeakElement {
    
    public static int find_peak_element_helper(int inp[], int low,int high)
    {
        int result = -1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            if(inp[mid]<inp[mid-1])
            {
                high = mid-1;
            }
            else if(inp[mid]<inp[mid+1])
            {
                low = mid+1;
            }
            else if(inp[mid]>inp[mid-1] && inp[mid]>inp[mid+1])
            {
                result = mid;   
                break;
            }
        }
        return result;
    }
    public static int find_peak_element(int inp[])
    {
        int n = inp.length;
        
        if(n==0)    return -1;
        if(n==1)    return 0;
        
        if(inp[0]>inp[1])       return 0;   // first element peak
        if(inp[n-1]>inp[n-2])   return n-1; // last element peak
        
        return find_peak_element_helper(inp,1,n-2);
    }
    
    public static void main(String[] args) {
        
        int inp[] = {1,2,1,3,5,6,4};
        
        System.out.println(find_peak_element(inp));
    }

}
