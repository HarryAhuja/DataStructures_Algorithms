package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class ValidPalindrome {
    
    public static boolean isPalindrome(String s)
    {
        int n = s.length();
        
        if(n==0 || n==1)    return true;
        
        int i=0,j=n-1;
        
        char c[] = s.toCharArray();
        
        while(i<j)
        {
            if(Character.isLetterOrDigit(c[i])==false)        i++;
            else if (Character.isLetterOrDigit(c[j])==false)  j--;
            else
            {
                if(Character.toLowerCase(c[i])!=Character.toLowerCase(c[j]))
                    return false;
                i++;
                j--;
            } 
        }
        return true;
    }
    public static void main(String[] args) {
        
        String inp = "0P";
        System.out.println(isPalindrome(inp));
    }

}
