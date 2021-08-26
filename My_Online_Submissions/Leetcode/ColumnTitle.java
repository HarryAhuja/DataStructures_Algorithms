package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class ColumnTitle {

    public static int find_title(String inp)
    {
        int ans = 0;
        int n   = inp.length();
        
        if(n == 0)    return ans;
        
        int base = 1;
        for(int i=n-1;i>=0;i--)
        {
            int offset = (inp.charAt(i)-'A')+1;
            
            ans  = ans + base*offset;
            base = base*26;
        }
        
        return ans;
    }
    public static void main(String[] args) {
        
        String inp  = "AB";
        System.out.println(find_title(inp));
        
    }

}
