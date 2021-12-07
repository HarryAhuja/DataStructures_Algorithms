/*
 * TC
 * "  hello world  " -> bcs hello has leading spaces, it will hit inside while loop
 *                      and append " " at the end 
 * "the sky is blue"-> bcs the don't have leading spaces result.append(sb) will hit and
 *                     will not append " " at the end
 *  Aim : don't append space after last word in both cases;
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class ReverseWordsInString {
    
    public static String reverseWords(String s)
    {
        if( s== null || s.length()==0)  return "";
        
        int n =s.length();
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        
        int i=n-1;
        
        while(i>=0)
        {
            char c = s.charAt(i);
            
            if(c==' ')
            {
                // if sb has some word
                if(sb.length()!=0)
                {
                    result.append(sb+" ");
                    
                    // clear sb for next word
                    sb.setLength(0);
                }  
            }
            else
            {
                // if space is not seen, then insert c at first position
                // appending c at last will make words reverse since we are 
                // traversing from right to left
                sb.insert(0, c);
            }
            i--;
        }
        
        // append last sb when it comes out of while loop
        result.append(sb);
        
        // to handle above discussed problem
        if(result.charAt(result.length()-1)==' ')   result.setLength(result.length()-1);
        
        return new String(result);
    }
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));

    }

}
