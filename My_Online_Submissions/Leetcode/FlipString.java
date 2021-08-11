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

/*

    Every character in the string has 2 choices,
    1) it can retain its value.
    2) it can be flipped.
    
    - We can have all 0s in the string,
    - We can have all 1s in the string,
    - We can have mixture of 0s and 1s but with the condition that no 0 should occur after 1
        -But the 1s can occur after 0s right!!
    
    Let us now try to build the logic,
    If in the string 1s are occuring after 0s , then there is no problem.
    But if 0s are coming after 1s then we have to think about options:
        1) Either we can flips 1s to 0s
        2) Flip 0s to 1s
    
    #Note: 
    We actually want 1s at the tail of string,
    so when we encounter 1 dont do anything but store its count,
    but when we encounter 0 then we have a option to flip it.
    
    Let us try to analyse this,
    At every iteration , we will calculate how many 0s are there to be flipped, and how many 1s we encountered,
    let us say,
    whenever we encounter '0' we will increment flip,
    and whenever we encounter '1' we will increment cnt,
    
    If there are no 1s then we are good,
    If there are no 0s then also we are good,
    But if there is combination of 0s and 1s then we need to consider,
    that among 1s and 0s which one to flipped,
    As we want to find out the minimum cost,
    We will consider the minimum among them,
    flip = min(flip,cnt)
 * 
 * */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class FlipString {
   
    public static int count_flip(String s)
    {
        int n                  = s.length();
      
        if(n==0 || n==1)    return 0;
        
        int ones   = 0;
        int zeroes = 0;
        
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='0')  zeroes++;
            else        ones++;
            
            zeroes = Math.min(zeroes, ones);
        }
        
        return zeroes;
    }
    public static void main(String[] args) {
        
        //String s = "10011111110010111011";
        String s = "1001";
        System.out.println(count_flip(s));

    }

}
