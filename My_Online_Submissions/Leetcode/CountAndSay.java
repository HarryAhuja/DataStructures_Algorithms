/*
 *   1.     1
     2.     11
     3.     21
     4.     1211
     5.     111221 
     6.     312211
     7.     13112221
     8.     1113213211
     9.     31131211131221
     10.   13211311123113112211
     
     i+1 sequence is count and say of previous one
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class CountAndSay {

    public static String countAndSay(int n)
    {
        if(n==0)    return "";
        if(n==1)    return "1";
        if(n==2)    return "11";
        
        StringBuilder current = new StringBuilder();
        StringBuilder prev    = new StringBuilder("11");
        
        for(int i=3;i<=n;i++)
        {
            //12345
            //1122344
            int j     = 1;
            int count = 1;
            while(j<prev.length())
            {
                if(prev.charAt(j)==prev.charAt(j-1))  
                {
                    count++;
                }
                else
                {
                    current.append(count+""+prev.charAt(j-1));
                    count = 1;
                }
                j++;
            }
            // dont write current.append(count+prev.charAt(j-1)+"");
            // otherwise count and ascii will be added
            current.append(count+""+prev.charAt(j-1));
            
            prev    = new StringBuilder(current);
            current.setLength(0);
        }
        return new String(prev);
    }

    public static void main(String[] args) {
        
        System.out.println(countAndSay(4));

    }

}
