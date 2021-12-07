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
        
        String prefix = inp[0];
        
        for(int i=1;i<n;i++)
        {
            while(inp[i].startsWith(prefix)==false)
            {
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        
        return prefix;
        
    }
    public static void main(String[] args) {
        String inp[] = {"flower","flow","flight"};
        
        System.out.println(find_longest_common_prefix(inp));

    }

}
