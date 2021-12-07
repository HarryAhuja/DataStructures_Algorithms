package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;


public class TrieImplemenation
{
    TrieNode root; 
    
    class TrieNode
    {
        TrieNode children[];
        boolean is_word;
        
        public TrieNode()
        {
            children = new TrieNode[26];
            for(int i=0;i<26;i++)   children[i] = null;
            is_word = false;
        }
    }
    
    public TrieImplemenation()
    {
        root = new TrieNode();
    }
    
    public void insert(String inp)
    {
        TrieNode temp = root;
        
        for(int i=0;i<inp.length();i++)
        {
            int c = inp.charAt(i)-'a';
            
            if(temp.children[c]==null)
            {
                temp.children[c] = new TrieNode();
            }
            
            temp = temp.children[c];
        }
        temp.is_word = true;
    }
    
    public boolean search(String inp)
    {
        TrieNode temp = root;
        
        for(int i=0;i<inp.length();i++)
        {
            int c = inp.charAt(i)-'a';
            
            if(temp.children[c]==null)
            {
                return false;
            }
            
            temp = temp.children[c];
        }
        return temp.is_word;
    }
    
    public boolean startsWith(String inp)
    {
        TrieNode temp = root;
        
        for(int i=0;i<inp.length();i++)
        {
            int c = inp.charAt(i)-'a';
            if(temp.children[c]==null)
            {
                return false;
            }
            temp = temp.children[c];
        }
        return true;
    }
   
}
