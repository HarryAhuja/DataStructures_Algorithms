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
    // Intialising hashmap in literal way
    // Map<String,Integer> map = Map.ofEntrie(Map.entry("a",1), Map.entry("b",2));
    // Linked HashMap to preserve the order bcs i wanted to use 1000 first and then 900
    // descending order-> above reason
    static LinkedHashMap<String,Integer> map = new LinkedHashMap<String, Integer>();
    boolean alreadyExecuted = false;
    
    public void init_map()
    {
        map.put("M",1000);
        map.put("CM",900);
        map.put("D",500);
        map.put("CD",400);
        map.put("C",100);
        map.put("XC",90);
        map.put("L",50);
        map.put("XL",40);
        map.put("X",10);
        map.put("IX",9);
        map.put("V",5);
        map.put("IV",4);
        map.put("I",1);
    }
    public String intToRoman(int num)
    {
        if(alreadyExecuted==false)
        {
            init_map();
            alreadyExecuted =  true;
        }
        
        
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, Integer>> entry_set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> itr  = entry_set.iterator();
        
        while(num>0)
        {
            // dont' reset itr back to 1000 bcs 
            // number is decreased now, we dont have to start again
            
            while(itr.hasNext())
            {
                Map.Entry<String, Integer> e = itr.next();
                String  key = e.getKey();
                Integer val = e.getValue();
                
                
                if(num>=val)
                {
                    int count = num/val;
                    for(int i=0;i<count;i++)    sb.append(key);
                    
                    num = num%val;
                }
            }
            
        }
        
        return new String(sb);
    }
}
