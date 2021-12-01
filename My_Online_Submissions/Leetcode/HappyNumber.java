/*
 * if its goes into endless loop, then its not happy number
 * 
 * loop = A->B->C->A
 * or
 * A->B->C->D->B(partial loop)
 * 
 * if n as A is again seen(hashset)
 * 
 * 29->85->89->145->42->20->4->16->37->58->89->145
 *         seen                           seen again -> same loop
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashSet;

public class HappyNumber
{
    HashSet<Integer> set = new HashSet<>();
    
    public int square_of_digits(int n)
    {
        int sum = 0;
        
        while(n>0)
        {
            int last_digit = n%10;
            sum+=(last_digit*last_digit);
            n = n/10;
        }
        return sum;
    }
    
    public boolean isHappy(int n)
    {
        if(n==1)    return true;
        
        if(set.contains(n)) return false;
        
        set.add(n);
        
        return isHappy(square_of_digits(n));
    }
}
