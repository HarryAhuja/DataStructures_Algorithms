package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class LongestCommonPrefix {

    /**
     * @param inp 
     * @return
     */
    public static String find_longest_common_prefix(String inp[])
    {
        int n = inp.length;
        
        if(n==0)    return "";
        if(n==1)    return inp[0];
        
        String ans = "";
        
        
        return ans;
        
    }
    public static void main(String[] args) {
        String inp[] = {"flower","flow","flight"};
        
        System.out.println(find_longest_common_prefix(inp));

    }

}
