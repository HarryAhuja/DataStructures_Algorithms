package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class JumpGame {
    public static boolean is_route_possible(int inp[])
    {
        int n = inp.length;
        
        int farthest = 0;
        
        if(n==0)    return false;
        if(n==1)    return true;            // [0]
        
        for(int i=0;i<n;i++)
        {
            if(i>farthest)  return false;
            
            farthest = Math.max(farthest, i+inp[i]);
            
            if(farthest>n-1)    return true;
                 
        }
        return true;
    }

    public static void main(String[] args) {
        
        int inp[] = {5,9,3,2,1,0,2,3,3,1,0,0};
        
        System.out.print(is_route_possible(inp));

    }

}
