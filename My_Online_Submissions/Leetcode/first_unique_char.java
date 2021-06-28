/*
 * Approach 1:
 * Start from last index and update the ans if its not in has map
 * last stored ans will be the required ans
 * Failed for "dddccdbba"
 * 
 * Time complexity : 2*O(n) where n is 10^5
 * Space complexity: 32bits as only lower alphabets are there
 * 
 * Approach 2:
 * 
 * 
 * How to check kth Set bit
 * 1.) Right shift by k bits and then bitwise AND with 0x1
 * 2.) Left shift 1 by k bits and take bitwise AND
 * 
 * How to set kth bit
 * 
 * 
*/

public class first_unique_char
{
    static int hash_map; 

    public static int firstUniqChar(String s) {
        
        int len = s.length();

        if(0 == len)    return -1;

        // This is important to reset for every test case
        hash_map         = 0;

        int ascii_offset = 0;
        int ans          = -1;
        
        for(int i=len-1; i>=0; i--)
        {
             ascii_offset = s.charAt(i)-'a';
             
            if(((hash_map>>ascii_offset)&0x1)==0)
            {
                ans = i;
                hash_map = hash_map | (1<<ascii_offset);
            }
            else if( (ans!=-1) && (s.charAt(i) == s.charAt(ans)))   // "bbdd"
            {
                ans = -1;
            }
        }

        return ans;
        
    }
    public static void main(String[] args)
    {
        String inp;

        //inp = new String("leetcode");
        //inp = new String("aabb");
        //inp = new String("bd");
        inp = new String("dddccdbba");

        System.out.println(firstUniqChar(inp));
    }
}