/*
 * TC    ans
 * 11 -> 0
 * 00 -> 0
 * 100 -> 1 (flip first 1)
 * 
 * That means we have to try flipping each and every bit
 * and check which takes min flips
 * 
 * index 
 * 0 1 2 3 4 5
 * 0 1 0 1 1 0
 * 1.) either makes all zeroes as one after first 1 from left side
 *     as initial zeroes before first 1 don't harm
 *     0 after 1 are wrong. We need to flip to 1
 *     
 * 2.) Or make first 1 as 0 and then you don't need to worry about
 *     0 in between flipped bit and next 1(0 of (1:2)). Count set bits 
 *     from first set bit(MSB) to last zero(MSB) bcs trailing 1 don't harm
 *     
 * Note: Any 1/0 to be flipped in above two points is the the bit
 *       At current considered location. It can be 1st or any
 *     
 * 3.) or it can be combination of 1 and 2 
 *     "10011111110010111011"
 *      1st 1(MSB) flipped to 0
 *      From 3rd 1, use 1st point
 *      Don't hardcode that min of 1st and 2nd would be answer.
 *      bcs we need to check all combinations
 * 
 * 4.) Ex, "0101100011" --> count total_set_bits until last 0
 *     not last 1 bcs trailing 1 don't harm
 * 
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class FlipString {
   
    public static int count_flip(String s)
    {
        int n                  = s.length();
        int prev_set_bit       = n;
        int flip_zeroes        = 0;
        int set_bits_total     = 0;
        boolean last_zero_seen = false;
        
        if(n==0 || n==1)    return 0;
        
        Integer i = Integer.valueOf(s, 2);
        
        
        while(i>0)
        {
            // Position of last set bit
            int curr_last_set_bit = n-(((int)(Math.log10(i&~(i-1))/Math.log10(2)))+1);
            
            flip_zeroes = flip_zeroes + (prev_set_bit-curr_last_set_bit-1);
            
            if(flip_zeroes>0 && (last_zero_seen == false))
            {
                last_zero_seen = true;
            }
            
            
            prev_set_bit = curr_last_set_bit;
            
            // Unset right most set bit
            i = (i&(i-1));
            
            if(last_zero_seen==true)    set_bits_total+=1;
        }
        
        return Math.min(flip_zeroes, set_bits_total); 
    }
    public static void main(String[] args) {
        
        String s = "10011111110010111011";
        //String s = "00110";
        System.out.println(count_flip(s));

    }

}
