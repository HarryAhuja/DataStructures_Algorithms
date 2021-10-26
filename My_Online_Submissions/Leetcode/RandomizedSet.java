/*
 *  I can't use array indices to map value and array bcs value can go from
 *  -2^31 to 2^31-1. So Set or map has to be used for sure
 *  
 *  No to store value in O(1), we can use array(with index) or arrayList(add at back)
 *  But while storing or removing, we have to check if value is present or not already
 *  Array and arraylist takes O(n) to search this thing
 *  So set or map is required
 *  
 *  To remove in O(1), array and arraylist takes O(n) to remove at random position
 *  but takes O(1) to remove from first or last position
 *  
 *  We we swap random index with last index and remove last index but this operation
 *  is also updated in set/map
 *  
 *  Set vs Map
 *  
 *  We need map to store index of key in the array list
 *  in remove(key)-> searching index of key will take O(n). We need index 
 *  to swap for last node
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet
{
    HashMap<Integer,Integer> map  = null;
    List<Integer>            list = null;
    public RandomizedSet()
    {
        map  = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int key)
    {
        if(map.containsKey(key)==false)
        {
            list.add(key);
            map.put(key, list.size()-1);
            return true;
        }
        else    return false;
    }
    
    public boolean remove(int key)
    {
        if(map.containsKey(key)==true)
        {
            int index_in_list = map.get(key);
            
            Collections.swap(list, index_in_list, list.size()-1);
            
            // We can't get random entry at particular index or for particular key
            
            // Get swapped key first
            int swapped_key = list.get(index_in_list);
            map.put(swapped_key, index_in_list);                           // updated swapped value in map
            
            list.remove(list.size()-1); // removed from LL
            map.remove(key);            // removed from map
            
            return true;
        }
        else    return false;
    }
    
    public int getRandom() {
        // no need of checking if DS is empty of not
        // given that There will be at least one element in the data structure when getRandom is called 
        
        /*
            Suppose i want to generate random number bw 1 to 10, both inclusive
            
            x = Math.random() gives 0.00 to 1.00(exlusive)
            10x will give 0.00 to 9.99
            (int)10x will give 0 to 9(9.99 is also converted into 9)
            for 1 to 10, add 1(min of range)
            
            now 1+(int)10x will give 1 to 10 (both inclusive)
            general formula
            
            min+(int)(Math.random()*(max-min+1))
        */
        
        int max        =  list.size()-1;
        int min        =  0;
        int rand_index = (int)(Math.random()*(max-min+1)) + min;
        
        return list.get(rand_index);
    }
}
