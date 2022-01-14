/*
 * Approach 1:
 * Start from last index and update the ans if its not in has map
 * last stored ans will be the required ans
 * Failed for "dddccdbba"
 * 
 * Time complexity : 2*O(n) where n is 10^5
 * Space complexity: 32bits as only lower alphabets are there
 * 
 * Approach 2:
 * Iterate from left to right
 * Update when first time char is seen
 * But this will give last unique char in string
 * Failed At : "dddccdbbae"
 * 
 * How to check kth Set bit
 * 1.) Right shift by k bits and then bitwise AND with 0x1
 * 2.) Left shift 1 by k bits and take bitwise AND
 * 
 * How to set kth bit
 * n = n | (1<<k);
 * 
 * 
 * Approach 3:
 * Linked hashmap for maintaining insertion order
 * 
 * Approach 4:
 * store index in 256 array
 * iterate over 256 and get the minimum index of freq=1
 * 
 * Here we don't need freq exactly
 * Store -1 when freq >=2 as a flag
 * So 1d array of index only is enough
 * 
*/
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;

class DLL_Node
{
    Character c;
    int index;
    DLL_Node next;
    DLL_Node prev;
    
    public DLL_Node(Character c,int i)
    {
        this.c = c;
        index  = i;
        next = prev = null;
    }
}

public class first_unique_char
{
    static DLL_Node head;
    static DLL_Node tail;
    
    public static void add_char(char c,int index, HashMap<Character,DLL_Node> hm,boolean visited[])
    {
        visited[c-'a'] = true;
        
        if(head==null)
        {
            head = new DLL_Node(c,index);
            tail = head;
            hm.put(c, head);
        }
        else
        {
            DLL_Node new_node = new DLL_Node(c,index);
            tail.next     = new_node;
            new_node.prev = tail;
            tail          = tail.next;
            hm.put(c, tail);
        }
    }
    
    public static void delete_char(char c,HashMap<Character,DLL_Node> hm)
    {
        DLL_Node ref = hm.get(c);
        
        // bcs we are putting null instead of removing
        if(ref==null)   return;
        
        //instead of removing, put null
        hm.put(c, null);
        
        // remove from DLL
        
        if(ref==head)
        {
            if(head.next!=null) head.next.prev  = null;
            head = head.next;
        }
        else if(ref==tail)
        {
            if(tail.prev!=null) tail.prev.next = null;
            tail = tail.prev;
        }
        else
        {
            if(ref.prev!=null)  ref.prev.next = ref.next;
            if(ref.next!=null)  ref.next.prev = ref.prev;
        }
    }
    public static int firstUniqChar(String s) {
        
        int len = s.length();
        
        if(0 == len)    return -1;

        HashMap<Character,DLL_Node> hm = new HashMap<>();
        boolean visited[] = new boolean[26];
        
        for(int i=0;i<len;i++)
        {
            char c = s.charAt(i);
            
            if(visited[c-'a']==false)
            {
               add_char(c,i,hm,visited);
            }
            else
            {
               delete_char(c,hm);
            }
        }
        
        if(head==null)  return -1;
        
        return head.index;
    }
    public static void main(String[] args)
    {
        String inp;

        //inp = new String("leetcode");
        //inp = new String("aabb");
        inp = new String("bd");
        //inp = new String("dddccdbba");

        System.out.println(firstUniqChar(inp));
    }
}