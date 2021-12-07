/*
 * It worked but very slow since substring and recursion are used
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class ReverseWordsInString {
    
    public static String reverseWords(String s)
    {
        if( s== null || s.length()==0)  return "";
        
        int n =s.length();
        StringBuilder sb = new StringBuilder();
        
        
        
        int i=0;
        // skipping leading spaces
        while(i<n && s.charAt(i) == ' ')
        {
            i++;
        }
        // building word
        while(i<n && s.charAt(i) != ' ')
        {
            sb.append(s.charAt(i)+"");
            i++;
        }
        String sub_ans = reverseWords(s.substring(i,n));
        
        if(sub_ans.equals("")==false)   
            return new String(sub_ans + " "+sb);
        else
            return new String(sb);
    }
    public static void main(String[] args) {
        System.out.println(reverseWords("  the sky is blue"));

    }

}
