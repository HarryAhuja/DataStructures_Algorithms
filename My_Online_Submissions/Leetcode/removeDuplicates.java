package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class removeDuplicates {
    
    public static int removeDuplicates(int[] nums) {
        int  k = 0 , i = 0;
        int  n = nums.length;
        int unique_element = 0;
        
        if(n==0)    return k;
        
        while(true)
        {
            unique_element = nums[i];
            while(i<n && nums[i] == unique_element)
            {
                i++;
            }
            if(i == n)  break;  
            else        nums[k++] = unique_element;
        }
        
        nums[k++] = unique_element;     
        
        return k;
    }
    public static void main(String[] args) {
        int inp[] = {0,0,1,1,1,2,2,3,3,4};
        int res = removeDuplicates(inp);
        for(int i=0;i<res;i++)
        {
            System.out.print(inp[i]+" ");
        }

    }
}
