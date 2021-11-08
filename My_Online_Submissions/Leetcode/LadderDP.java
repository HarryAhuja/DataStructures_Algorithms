/*
 *  Time  = O(k^n)
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class LadderDP {

    public static int no_of_ways(int n,int k)
    {
        // either put condition at calling or at this point(after called)
        if(n<0)     return 0;
        if(n==0)    return 1;
        
        int ans = 0;
        for(int i=1;i<=k;i++)
        {
            ans += no_of_ways(n-i,k);
        }
        return ans;
    }
    public static void main(String[] args) {
       
        int n = 4, k = 3;
        
        System.out.println(no_of_ways(n,k));

    }

}
