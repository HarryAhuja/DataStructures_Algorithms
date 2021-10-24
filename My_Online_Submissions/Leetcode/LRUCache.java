/*
 * If a thread-safe implementation is not needed, it is recommended to use HashMap 
 * in place of Hashtable. If a thread-safe highly-concurrent implementation is desired,
 *  then it is recommended to use java.util.concurrent.ConcurrentHashMap in place of Hashtable.
 *  
 *  LRU node can be put at head or tail
 *  But when a node is used, it was to be replaced with head or tail
 *  replacement can be done in two ways, either data or full node
 *  Since in hashmap we have stored address, its better to replace full node bcs
 *  its address and value will not change. Just the position will change.
 *  In hashmap we have not stored the position, so we don't have to update hashmap
 *  
 *  Use doubly LL to remove a node if reference to that node is only given
 *  
 *  Assumptions
 *  1.) LRU key will be at tail bcs we are inserting at head
 *  2.) 1->2->3->4
 *     Suppose get(3), after that
 *     3->2->1->4  --> but this is wrong bcs acc to this 1 is older than 2 bcs of
 *     sequence but it is not the case. 1 is mostly used than 2.
 *     So instead of replacing move in sequence
 *  
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashMap;

class DoubleNode
{
    int key;
    int val;
    DoubleNode next;
    DoubleNode prev;
    public DoubleNode() {key = -1;val = -1; next=prev=null;}
    public DoubleNode(int k,int v) {key =k; val = v; next=prev=null;}
}

public class LRUCache {
    
    static int size;
    static int max_capacity;
    static HashMap<Integer,DoubleNode> map;
    static DoubleNode list;
    static DoubleNode tail;
    
    public LRUCache(int capacity)
    {
        size         = 0;
        max_capacity = capacity;
        list         = new DoubleNode();
        tail         = list;
        map          = new HashMap<>();
    }
    
    public static void remove_node_in_ll(DoubleNode node)
    {
        // Three case: head, random,tail node
        
        //Tail
        // 3 case: tail is same as head, tail is first node, tail is last node
        // Dummy, Dummy->tail, dummy->n1->n2->tail
        // 1st case can't be there bcs caller is called only when key is present
        // and 1st case only arises if there is no key
        if(node==tail)
        {
            tail.prev.next = null;
            tail           = tail.prev;
        }
        // Head
        // 3 cases-> list.next is null , Dummy->node, Dummy->node->n2
        // 1st case will not arise bcs of same explanation
        else if(node==list.next)
        {
            node.prev.next = node.next;
            // 2nd case
            if(node.next!=null) node.next.prev = list;
        }
        // Random node
        else
        {
            node.prev.next = node.next;
            if(node.next!=null) node.next.prev = node.prev;
        }
       
        node.prev      = null;
        node.next      = null;
    }
    public static void add_node_in_ll(DoubleNode node)
    {
        // Cases: first node, random node
        
        // Order matters
        node.next      = list.next;
        node.prev      = list;
        list.next      = node;
        if(node.next!=null) node.next.prev = node;
        
        //update tail
        if(tail==list)  tail = node;
    }
    
    public static void move_to_head(DoubleNode node)
    {
        // Re-using 1.) remove+add
        
        remove_node_in_ll(node);
        map.remove(node.key);
        
        DoubleNode new_node = new DoubleNode(node.key,node.val);
        add_node_in_ll(new_node);
        map.put(node.key,new_node );
        
    }
    
    public static void remove_tail()
    {
        // Remove from hashmap
        // we can't do tail.val bcs key and val can be different
        // Because of this we have to store key as well in node
        map.remove(tail.key);
        
        // re-using function
        remove_node_in_ll(tail);   
    }
    
    public static int get(int key)
    {
        DoubleNode node = map.get(key);
        if(node!=null)
        {
            move_to_head(node);
            return node.val;
        }
        else    return -1;
    }
    
    public static void put(int key, int value)
    {
        DoubleNode node = map.get(key);
        
        if(node != null)
        {
            node.val = value;
            move_to_head(node);
        }
        else //new key value pair
        {
            DoubleNode new_node = new DoubleNode(key,value);
            
            if(size<max_capacity)   size++;
            else
            {
                // tail.prev can only be null at dummy node
                // this else will never hit as size >=! capacity unless
                // capacity is zero
               remove_tail();           // From LL and map both                
            }
            
            add_node_in_ll(new_node);
            map.put(key, new_node);
        }
        
        
    }
    public static void main(String[] args) {
        //1, -1 , -1 ,3, 4
        // 1 ,2 , 1 , 3 ,4
        LRUCache cache = new LRUCache(2);
        put(1, 1);
        put(2, 2);
        System.out.println(get(1));
        put(3, 3);
        System.out.println(get(2));
        put(4, 4);
        System.out.println(get(1));
        System.out.println(get(3));
        System.out.println(get(4));
        

    }

}
