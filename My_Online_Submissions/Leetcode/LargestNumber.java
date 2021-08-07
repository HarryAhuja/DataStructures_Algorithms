package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class MyComparator implements Comparator<String>
{
    public int compare(String obj1,String obj2)
    {
        // obj1 = "30"
        // obj2 = "3"
        
        // Case1 = str1+str2 = 303
        // Case2 = str2+str1 = 330
        
        // Case 2 Apparently is bigger in terms of value
        
        String str1  = obj1+obj2;
        String str2  = obj2+obj1;
        
        return str2.compareTo(str1);
    }
}
public class LargestNumber {
    
    public static String largest_number(int inp[])
    {
        String result = "";
        
        ArrayList<String> str_list = new ArrayList<>(inp.length);
        
        for(int i=0;i<inp.length;i++)
        {
            str_list.add(Integer.toString(inp[i])); 
        }
        
        Collections.sort(str_list,new MyComparator());
        
        Iterator<String> itr = str_list.iterator();
        
        while(itr.hasNext())
        {
            result = result + itr.next();
        }
        
        if(result.charAt(0) == '0') return "0";
            
        
        return result;
    }

    public static void main(String[] args) {
        
        int nums[] = {0,0};

        System.out.println(largest_number(nums));
    }

}
