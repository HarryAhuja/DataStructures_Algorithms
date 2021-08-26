package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class ValidPalindrome {
    public static boolean is_alphanumeric(char c)
    {
        if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9'))
            return true;
        return false;
    }
    public static boolean isPalindrome(String s)
    {
        int n = s.length();
        
        if(n==0 || n==1)    return true;
        
        int i=0,j=n-1;
        
        while(i<j)
        {
            char  ith_char = s.charAt(i);
            char  jth_char = s.charAt(j);
            boolean low    = is_alphanumeric(ith_char);
            boolean high   = is_alphanumeric(jth_char);
            
            if((low == true) && (high == true))
            {
                int diff = Math.abs(ith_char-jth_char);
                
                // Can't do like this bcs diff 32 can be for
                // mismatching chars also
                if(diff == 32 || diff == 0)
                {
                    i++;
                    j--;
                }
                else    return false;
            }
            else if(low == false)   i++;
            else                    j--;
        }
        return true;
    }
    public static void main(String[] args) {
        
        String inp = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(inp));
    }

}
