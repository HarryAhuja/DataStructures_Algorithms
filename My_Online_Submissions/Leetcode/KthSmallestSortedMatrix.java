package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class KthSmallestSortedMatrix {
    
    public static int count_elements(int mat[][], int rows,int cols,int target)
    {
        int i      = rows-1;
        int j      = 0;
        int result = 0;
        
        while(i>=0 && j<cols)
        {
            if(mat[i][j]>target) i--;
            else
            {
                result += (i+1);
                j++;
            }
        }
        return result;
    }
    public static int k_smallest_element_helper(int mat[][], int k, int rows, int cols)
    {
        int low  = mat[0][0];
        int high = mat[rows-1][cols-1];
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            int count = count_elements(mat,rows,cols,mid);
            
            if(count<k) low  = mid+1;
            else        high = mid-1;
        }
        
        return low;
    }

    public static int k_smallest_element(int mat[][], int k)
    {
        int rows = mat.length;
        int cols = mat[0].length;
        
        return k_smallest_element_helper(mat, k,rows,cols);
    }
    public static void main(String[] args) {
        
        int mat[][] = {{1,5,9},{10,11,13},{12,13,15}};
        int k       = 8;
        
        System.out.println(k_smallest_element(mat,k));

    }

}
