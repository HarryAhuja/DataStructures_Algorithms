/*
 * Can be a case
 * 
 * target = "rry"
 * input  = "harrry"
 * 
 * inp = "mississippi"
 * tar = "issip"
 * If we put first n chars in the window directly iterating
 * wrong ans bcs we start substring starts from s but
 * substring should start from i
 * 
 * that is why use brute force first
 * then kmp or raben karp or boyre moore
 * But if string is small, then don't run
 * 
 * it doesn't start from first r but second r
 * while comparing from first r, we can't skip full target
 * and jump directly
 * 
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class strstr {
    public static int is_present(String inp,String target)
    {
        int m = inp.length();
        int n = target.length();
        
        // Empty string appears everywhere, return 0 index
        if(n == 0)         return 0;
        if(m==0 || m<n)    return -1;
        
        int i = 0, j = 0;
        
        while(i<=m-n)
        {
            j = 0;
            while(j<n)
            {
                if(target.charAt(j)!=inp.charAt(i+j))   break;
                j++;
            }
            if(j==n)    return i;
            
            i++;
        }
       
        return -1;
    }
    public static void main(String[] args) {
        
        String inp    = "aa";
        String window = "a";
        
        System.out.println(is_present(inp,window));
    }
}
