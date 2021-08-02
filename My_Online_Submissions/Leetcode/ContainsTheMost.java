package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class ContainsTheMost {
    
    public static int most_water(int inp[])
    {
        int max_water = 0;
        int low  = 0;
        int high = inp.length-1;
        
        while(low<high)
        {
            max_water = Math.max(max_water, (high-low)*(Math.min(inp[low], inp[high])));
            
            if(inp[low]<inp[high])
            {
                low++;
            }
            else
            {
                high--;
            }
        }
        
        return max_water;
    }

    public static void main(String[] args) {
       
        int height[] = {1,8,6,2,5,4,8,3,7};
        
        System.out.println(most_water(height));

    }

}
