package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

class PrefixNode
{
    PrefixNode children[];
    int children_count;
    boolean is_word;
    
    public PrefixNode()
    {
        children = new PrefixNode[26];
        for(int i=0;i<26;i++)   children[i] = null;
        children_count = 0;
        is_word = false;
    }
}

public class LongestCommonPrefix
{

    static PrefixNode root = new PrefixNode();
    
    public static void build_trie(String inp)
    {
         PrefixNode temp = root;
         
         for(int i=0;i<inp.length();i++)
         {
             int c = inp.charAt(i)-'a';
             
             if(temp.children[c]==null)
             {
                 temp.children[c] = new PrefixNode();
                 temp.children_count++;
             }
             
             temp = temp.children[c];
         }
         temp.is_word = true;
    }
    
    public static String find_longest_common_prefix(String inp[])
    {
        int n = inp.length;
        
        if(n==0)    return "";
        if(n==1)    return inp[0];
        
        for(int i=0;i<n;i++)
            build_trie(inp[i]);
        
        StringBuilder sb = new StringBuilder();
        
        PrefixNode temp = root;
        
        /*
         *  Why is_word ==true
         *             root
         *              f
         *              l
         *              o
         *              w -> is_word=true
         *              e
         *              r -> is_word=true
         *              
         * if is_word condition is not applied then prefix of flower,flow=flower not flow
         * 
         * Another TC = When "" is input string
         * ["","b"] -> ans is ""
         * 
         * while inserting "" in trie, root->is_word=true and this breaks while searching
         * for prefix. If this is not there, then "b" is output which is wrong 
         * 
         */
        
        while(temp!=null && temp.is_word==false && temp.children_count==1)
        {
            int i;
            for(i=0;i<26;i++)   
            {
                if(temp.children[i]!=null)  break;
            }
            
            sb.append((char)(i+'a'));
            
            temp = temp.children[i];
        }
        
        return new String(sb);
        
    }
    public static void main(String[] args) {
        String inp[] = {"","b"};
        
        System.out.println(find_longest_common_prefix(inp));

    }

}
