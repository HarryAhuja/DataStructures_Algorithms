package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class ValidPalindrome {
    public static boolean is_alphanumeric(String s)
    {
        char c = s.charAt(0);
        
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
            String  ith_str = s.charAt(i)+"";
            String  jth_str = s.charAt(j)+"";
            
            boolean low  = is_alphanumeric(ith_str);
            boolean high = is_alphanumeric(jth_str);
            
            if(low == true && high==true)
            {
                if(ith_str.equalsIgnoreCase(jth_str))
                {    
                    i++;j--;
                }
                else    return false;
            }
            else if(low==false) i++;
            else                j--;
            
        }
        return true;
    }
    public static void main(String[] args) {
        
        String inp = "0P";
        System.out.println(isPalindrome(inp));
    }

}
