package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class RabinKarp {
    // A prime number
    final static int prime = 1000007;
    final static int base = 10;
    
    public static void search(String pat,String text)
    {
        int i = 0;
        int m = pat.length();
        int n = text.length();
        int hash_code_pattern = 0;
        int hash_code_text    = 0;
        
        // precompute. We will need this while eliminating leading digit
        int h =(int) Math.pow(base, m-1);
        
        // pattern is longer than text itself
        if(n<m) return ;
        
        // calculate hash_code of pattern and first m chars of 
        for(i=0;i<m;i++)
        {
            // start a from 1 to 26. Dont take 0 bcs of multiplication 
            int p_c = (pat.charAt(i)-'a')+1;  
            int t_c = (text.charAt(i)-'a')+1;  
            hash_code_pattern = (hash_code_pattern + (p_c*((int)Math.pow(base, m-1-i))))%prime;
            hash_code_text    = (hash_code_text + (t_c*((int)Math.pow(base, m-1-i))))%prime;
        }
        
        
        // to check if first window is same
        if(hash_code_pattern==hash_code_text)
        {
            for(int x=0;x<m;x++)
            {
                
            }
        }
        
        for(;i<n;i++)
        {
            
            int prev = (text.charAt(i-m)-'a')+1;
            int curr = (text.charAt(i)-'a')+1;
            hash_code_text = (((hash_code_text- prev*h)*base)+curr)%prime;
            
            // this check every window including last window
            // it will not check first window since calculation is done first
            // so first window is checked separately
            if(hash_code_pattern==hash_code_text)
            {
                
                System.out.println("Pattern matched at index "+(i-m+1)+" in "+text);
                break;
            }
        }
    }
    public static void main(String[] args) {
        String txt = "aaaaab";
        String pat = "aab";
            
          // Function Call
        search(pat, txt);

    }

}
