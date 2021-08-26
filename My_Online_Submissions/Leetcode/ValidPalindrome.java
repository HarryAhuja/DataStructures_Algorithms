/*
 * Mapping approach
 * Instead of using ascii directly
 * 
 * Make a charMap whose key will be same for 'a' and 'A'
 * Then directly compare both
 * 
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class ValidPalindrome {
    
    public static boolean isPalindrome(String s)
    {
        int n = s.length();
        
        if(n==0 || n==1)    return true;
        
        /*
         * build an array that map all possible char into integer
         * (if not alphanumeric,mark it as zero)
         * (1+i) or (11+i) is just reservation positions
         * actual char at these positions may be unprintable
         * ascci in memory
         * 
         * use int array instead of char array
         * 
         * 0-9         : Positions[1-10]
         * a-z and A-Z : Positions[11-36]
         */
        int charMap[] = new int[256];
        
        for(int i=0;i<10;i++)
        {
            charMap['0'+i] = (1+i);   // 0 is reserved for illegal chars
        }
        for(int i=0;i<26;i++)
        {
            // +i is done so that we can access directly
            // we don't have to subtract base value 
            // based on which sequence
            charMap['a'+i] = charMap['A'+i] = (11+i);
        }
        
        int i=0,j=n-1;
        
        // This can take time bcs if very long string
        // which is not palindrome will be converted 
        // Instead convert char while iterating, if its not
        // palindrome it will not convert full string
        //char c[] = s.toCharArray();
        
        while(i<j)
        {
            int low  = charMap[s.charAt(i)];
            int high = charMap[s.charAt(j)];
            
            if(low == 0)     i++;
            else if(high==0) j--;
            else
            {
                if(low!=high)   return false;
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
