package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class PlusOne {
    
    public static int[] plusOne(int[] digits) {
        
        int n = digits.length;
        
        if(n == 0)  return new int[] {};
        
        for(int i=n-1;i>=0;i--)
        {
            if(digits[i]<9)
            {
                digits[i]+=1;
                return digits;
            }
            // Any digit == 9 will be filled with 0
            // And in next iteration, its next bit will be incremented
            // by 1 if less than 9. If not less than 9,filled with 0
            digits[i] = 0;
        }
        
        // This line would only hit in following cases(all 9)
        // 9,99,999. Because if any of the digit is less than 9, it
        // will return from above
        // index from 1 to n will be filled with 0 by default
        // we only need to fill one 1 at start
        int result[] = new int[n+1];
        result[0] = 1;
        
        return result;
        
    }
    public static void main(String[] args) {

        int digits[] = {9};
        int res[] = plusOne(digits);
        for(int i=0;i<res.length;i++)
        {
            System.out.println(res[i]+" ");
        }

    }

}
