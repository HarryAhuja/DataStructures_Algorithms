package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class PlusOne {
    
    public static int[] plusOne(int[] digits) {
        
        int n = digits.length;
        
        if(n == 0)  return new int[] {};
        
        int carry = 1; //plus one
        int index = digits.length-1;
        
        // when carry==0, that means +1 is done at somewhere
        while(index>=0 && carry>0)
        {
            digits[index] = (digits[index]+carry)%10;
            carry         = (digits[index]==0)?1:0;
            index--;
        }
        // Assumptions that msb can't be 0. That means if digits[0] is
        // 0 that means all its trailing numbers should be 0
        // Therefor no need for copying digits 1 to n to result
        
        //All 9s case
        if(carry>0)
        {
            int result[] = new int[n+1];
            result[0] = 1;
            // return new length array only in this case
            return result;
        }
        
        // Return default size array
        return digits;
        
    }
    public static void main(String[] args) {

        int digits[] = {1,2,3};
        int res[] = plusOne(digits);
        for(int i=0;i<res.length;i++)
        {
            System.out.println(res[i]+" ");
        }

    }

}
