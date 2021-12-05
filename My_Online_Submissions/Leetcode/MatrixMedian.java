package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class MatrixMedian
{
    public static int count_numbers(int a[],int key)
    {
        // upper bound
        
        // since if this function is called that means
        // first element<=key
        // so we need to just find out upper bound. Lower bound is index=0 always
        
        int low    = 0;
        int high   = a.length-1;
        int result = 0;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            if(a[mid]<=key)
            {
                result = mid;
                low = mid+1;
            }
            else                high = mid-1;
        }
        
        // result +1 bcs result is index. We need count
        // return result+1 or low.
        // Low will cross high and point to index where element >key(which will be req count)
        return result+1;
    }
    
    public static int median_matrix(int M[][])
    {
        int n = M.length;
        int m = M[0].length;
        
        int low  = 1;
        int high = 1000000000; // int is between 1 to 10^9
        int median_pos = n*m/2;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            int count = 0;
            
            //iterate over each row
            for(int i=0;i<n;i++)
            {
                // If first element is greater than mid, than whole array 
                // would be greater since each row is sorted
                if(M[i][0]>mid) continue;
                
                count+= count_numbers(M[i],mid);
            }
            
            
            if(count<=median_pos)   low  = mid+1;
            else                    high = mid-1;
        }
        
        return low;
    }
    
    public static void main(String[] a)
    {
        int mat[][] = {{1,3,6},{2,6,9},{3,6,9}};
        
        System.out.println(median_matrix(mat));
    }
    
}
