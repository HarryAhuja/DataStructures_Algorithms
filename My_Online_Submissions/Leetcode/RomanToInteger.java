/*
 * 44 = XLIV
 * Approach 1: Just keep on adding and and take abs at end
 * = 10-50+1-5 ( neg sign if value is greater than prev)
 * = -44 = 44(abs)
 * 
 * 43 = XLIII
 * = 10-50+1+1+1 = 37 (failed)
 * 
 * 
 * Approach 2:
 * If 2nd value is greater than do second-first, 
 * otherwise keep on incrementing
 * 
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;

public class RomanToInteger {
    static HashMap<Character,Integer> map = new HashMap<>();
    
    static public void initialise_hash_map()
    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    
    public static int roman_to_int(String inp)
    {
        initialise_hash_map();
        
        int ans = 0;
        int n   = inp.length();
        
        if(n==0)    return ans;
        if(n==1)    return map.get(inp.charAt(0));
        
        int i    = 0;
        int curr = 0;
        int prev = 0;
        while(i<n)
        {
            curr = map.get(inp.charAt(i));
            
            if(prev!=0 && prev<curr)
            {
                ans+=(curr-prev)-prev;
            }
            else
            {
                ans +=curr;
            }
            prev = curr;
            i++;
        }
        
        return ans;
    }
    public static void main(String[] args) {
        String inp = "XLIV";
        
        System.out.println(roman_to_int(inp));

    }

}
