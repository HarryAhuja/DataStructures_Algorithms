package datastructures.DataStructures_Algorithms.My_Online_Submissions.Online_Assessment;

public class FlipCoins
{
    public static void main(String args[])
    {
        String str = "HH";
        
        int n = str.length();
        int count1 = 0;
        int i = 0;
        
        while(i<n && str.charAt(i)=='T')
        {
            i++;
            count1++;
        }
        
        boolean t_seen = false;
        while(i<n)
        {
            if(str.charAt(i)=='H' && t_seen==true)
            {
                count1++;
            }
            else if(str.charAt(i)=='T')
            {
                t_seen = true;
            }
            i++;
        }
        
        int count2 = 0;
        i = n-1;
        
        while(i>=0 && str.charAt(i)=='H')
        {
            i--;
            count2++;
        }
        
        boolean h_seen = false;
        while(i>=0)
        {
            if(str.charAt(i)=='T' && h_seen==true)
            {
                count2++;
            }
            else if(str.charAt(i)=='H')
            {
                h_seen = true;
            }
            i--;
        }
        
        System.out.println(Math.min(count1, count2));
    }
}
