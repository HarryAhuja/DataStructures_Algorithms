/*
 * Divide until remainder is zero or remainder is repeating(then quotient will keep
 * on recurring)
 * 
 * 8/4 = 2
 * 37/2=18.5
 * 428/125=3.424
 * 14/3=4.66666.... = 4.(6)
 * 93/7 = 13.(285714) -> same remainder is seen when quotient was 13. and 13.285714
 * 
 * suppose divisor=3 and dividend=14
 * when first time remainder is 2,q was 4.
 * then we multiple 2 with 10=20 and 18 was subtracted-> so bcs of this 2(20), 6 was introduced
 * in q (4.6) -> so save all q which was appended after 2 was seen for first time
 * if 2 is seen again, all that saved q is repeating
 * 
 * In hashmap, save remainder against the q it was seen. It will help to define the opening
 * bracket
 * 
 * 2    ->  4.
 * 
 * q=4.6 
 * now 2 is again seen-> so put ( after mapping of 2 in hashmap) ->4.(6
 * closing after 2 is seen again -> 4.(6)
 * 
 * Algo
 * For one given num and den, if first remainder is zero then return quotient-> no need
 * of decimal
 * 
 * After we put dot-> only first time if need to add more than one zero, we put zero
 * also in q, otherwise after that as many as zeroes we can add in remainder
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;

public class FractionToRecurringDecimal
{
    public static String fractionToDecimal(int numerator, int denominator)
    {
        if(numerator==0)    return "0";
        
        StringBuilder ans = new StringBuilder();
        HashMap<Long,Integer> map = new HashMap<>();
        long q;
        
        // Handle sign
        ans.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        
        // dont't write (long) Math.abs(numerator)
        // bcs numerator is int. So if -2147483648 is passed as int
        // -2147483648 is returned
        long num    = Math.abs((long)numerator);
        long den    = Math.abs((long)denominator);
        
        // First iteration
        long rem = num%den;
        ans.append(num/den);
        
        if(rem==0)  return ans.toString();
        else        ans.append('.');
        
        while(rem!=0)
        {
            if(map.containsKey(rem)==false)
            {
                map.put(rem, ans.length());
            }
            else
            {
                //String prev_seen = map.get(rem);
                //int index        = ans.indexOf(prev_seen);
                //ans.insert(index+prev_seen.length(), '(');
                // These three lines can be replaced by storing length of quotient
                // instead of string and then finding its length
                // since we are storing full length of q when putting in hashmap
                // so offset in insert will be from 0 only
                ans.insert(map.get(rem), "(");
                ans.append(')');
                break;
            }
            rem   = rem*10;         // Multiply by base to get carry over
            q = rem/den;
            rem   = rem%den;
            ans.append(q);
        }
        
        return ans.toString();
    }
    public static void main(String[] a)
    {
        System.out.println(fractionToDecimal(-1,-2147483648));
    }
}
