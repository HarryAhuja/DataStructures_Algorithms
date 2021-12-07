/*
 * if int = 2500
 * M -> 1000
 * it will be two M's(2000+500)
 * MMD
 * 
 * 2500/1000 = 2 -> this number tells how many M should be placed
 * 
 * then after placing 2 M's, remaining number would be 2500%1000=500
 * 
 * then so on
 * 
 * Start from highest number to lowest number
 * 
 * Challenge-> special cases
 * Solution -> insert special cases in hashmap in sorted order
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class IntegerToRoman
{
    static String key_db[]  = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    static Integer val_db[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    
    public static String intToRoman(int num)
    {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(num>0)
        {
            // dont' reset itr back to 1000 bcs 
            // number is decreased now, we dont have to start again
            
            while(i<key_db.length)
            {
                int val = val_db[i];
            
                if(num>=val)
                {
                    int count = num/val;
                    for(int j=0;j<count;j++)    sb.append(key_db[i]);
                    
                    num = num%val;
                }
                i++;
            }
            
        }
        
        return new String(sb);
    }
    
    public static void main(String[] a)
    {
        System.out.println(intToRoman(400));
    }
}
