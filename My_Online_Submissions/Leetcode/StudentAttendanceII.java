package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;

public class StudentAttendanceII {

    static char letters[] = new char[] {'a','l','p'};
    static int mod = (int)Math.pow(10,9)+7;
    
    static HashMap<String,Integer> hm= new HashMap<String,Integer>();
    
    public static int MaxEligibleCount(StringBuilder str,int n,int l,int a)
    {
        String pattern = n+""+l+""+a;
        if(hm.containsKey(pattern))
        {
            return hm.get(pattern);
        }
        
        if(n==0)
        {
            System.out.println(str);
            return 1;
        }
        
        int ans = 0;
        
        for(int i=0;i<3;i++)
        {
            char c = letters[i];
            
            // add only if we dont have a single a
            if(c=='a' && a<1)
            {
                str.append(c);
                ans+=MaxEligibleCount(str,n-1,0,a+1);
                str.deleteCharAt(str.length()-1);
            }
            // can add only we have not more than 2 consecutive L's
            else if(c=='l' && l<2)
            {
                str.append(c);
                ans+=MaxEligibleCount(str,n-1,l+1,a);
                str.deleteCharAt(str.length()-1);
            }
            else if(c=='p')
            {
                str.append(c);
                ans+=MaxEligibleCount(str,n-1,0,a);
                str.deleteCharAt(str.length()-1);
            }
            ans%=mod;
        }
        
        hm.put(pattern,ans);
        
        return ans;
    }
    public static void main(String[] args) {
       
        int n = 2;
        System.out.println(mod);
        StringBuilder str = new StringBuilder(); 
        System.out.println(MaxEligibleCount(str,n,0,0));

    }

}
