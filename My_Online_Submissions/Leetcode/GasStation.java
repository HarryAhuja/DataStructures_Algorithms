package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        
        if(n==0)    return -1;
        
        int total       = 0;    
        int tank        = 0;
        int start_index = 0;
        
        for(int i=0;i<n;i++)
        {
            tank+= (gas[i]-cost[i]);
            total+= (gas[i]-cost[i]);
            
            if(tank<0)
            {
                start_index = i+1;
                tank = 0;
            }
        }
        
        return (total<0?-1:start_index);
    }
}

public class GasStation {

    public static void main(String[] args) {
        
        int gas[] = {1,2,3,4,5}, cost[] = {3,4,5,1,2};
        
        Solution s = new Solution();
        
        System.out.println(s.canCompleteCircuit(gas, cost));
    }

}
