/*
 * We can't take long to check out of bounds bcs it fails at tc
 * 9223372036854775808  -> 2^63 ( but long range is 2^63-1)
 * 
 * so use long not until last parsed value and then check limits
 * use long value to check intermediate value
 * 
 * if value at anytime crosses Int.max(since we are taking magnitude only)
 * value can cross Int.max only not int min
 * 
 * Since int min and int max differes by only 1, we can say that if it crosses
 * int max then it will wrap around to int min also
 * 
 * either store crossed value in long and than compare with integer limits 
 * or instead of using long compare it without storing
 * 
 * Long i=(Integer.MAX_VALUE-2)*1L;  -> *1L to convert it into long
 *   
 * for(;i<Integer.MAX_VALUE+5L;i++)     
 * 
 * if i<Integer.MAX_VALUE+5  -> Integer.MAX_VALUE+5 will be converted to int bcs both
 * constants are integer-> it will overlflow and become false
 * 
 * Integer.MAX_VALUE+5L -> it will be actual value bcs of long
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class Atoi {

    public static int myAtoi(String s)
    {
        int parsed  = 0 ; 
        int i       = 0;
        
        int n       = s.length();
        int is_pos  = 1;
        
        if(n==0)    return 0;
        
        // leading space
        while(i<n && s.charAt(i)==' ')  i++;
        
        // handle signs
        if(i<n && ((s.charAt(i)=='-') || (s.charAt(i)=='+')))
        {
            is_pos = (s.charAt(i)=='-')?-1:1;  // make it neg
            i++;
        }
        // read digits and stop when non digit is seen
        while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9')
        {
            int c = s.charAt(i)-'0'; 
            
            // (Long)(parsed*10+c)
            // (Long)(parsed*10+c)*1L
            // (parsed*10+c)*1L 
            // all these will not work since parsed*10 both are int and 
            // have already wrapped around
            if( (parsed*10L+c)>Integer.MAX_VALUE)    
                return (is_pos==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            
            parsed = parsed*10+c;
            
             
            i++;
        }
        
        parsed = parsed*is_pos;
        
        return parsed;
    }
    public static void main(String[] args) {
        
        System.out.println(myAtoi("9223372036854775808"));

    }

}
