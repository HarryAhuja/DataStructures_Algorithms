/*
 * Order doesn't matter
 * Output   = [["bat"],["eat","tea","ate"],["tan","nat"]]
 * Expected = [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;

class Node implements Comparator<Node>
{
    public String original_value;
    public String s;
    
    public Node()
    {
        this.original_value = "";
        this.s              = "";
    }
    
    public Node(String original_value,String s)
    {
        this.original_value = original_value;
        this.s              = s;
    }

    @Override
    public int compare(Node o1, Node o2) {
        String str1 = o1.s;
        String str2 = o2.s;
        
        return str1.compareTo(str2);
    } 
}

public class GroupAnagrams {
    
    public static List<List<String>> group_anagrams(String str[])
    {
        // Don't write new ArrayList<String>();
        // Otherwise CE
        List<List<String>> result       = new ArrayList<>();
        ArrayList<String> temp_arr_list = new ArrayList<String>();
        
        
        int n = str.length;
        
        if(n == 0)  return result;
        
        Node node_array[]  = new Node[n];
        
        // Sort word wise
        for(int i=0;i<n;i++)
        {
            String s = str[i];

            char char_arr[] = s.toCharArray();
            Arrays.sort(char_arr);
            
            // Convert char array into String
            node_array[i]       = new Node(s,String.valueOf(char_arr));
        }
        
        // Sort whole String array
        Arrays.sort(node_array,new Node());
        
        // Add first element
        int i = 1;
        temp_arr_list.add(node_array[0].original_value);
        
        while(i<n)
        {
            if(node_array[i].s.equals(node_array[i-1].s)==true)
            {
                temp_arr_list.add(node_array[i].original_value);
            }
            else
            {
                // Add new array list, if new AL is not made
                // then its pass by reference
                result.add(new ArrayList<String>(temp_arr_list));
                temp_arr_list.clear();
                temp_arr_list.add(node_array[i].original_value);
            }
            i++;
        }
        // Add Last made array List
        result.add(new ArrayList<String>(temp_arr_list));
        
        return result;
    }
    public static void main(String[] args) {
        
        String str[] = {"eat","tea","tan","ate","nat","bat"};
        
        List<List<String>> result = group_anagrams(str);
        
        System.out.println(result);
        
        /* Iterator 2d List
         * Iterator<List<String>> itr = result.iterator();
        while(itr.hasNext())
        {
            List<String> each_list = (List<String>)itr.next();
            
            Iterator<String> each_list_itr = each_list.iterator();
            
            while(each_list_itr.hasNext())
            {
                System.out.print(each_list_itr.next()+" ");
            }
        }
        */
    }

}

