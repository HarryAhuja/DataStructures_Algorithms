/*
 * Problem
 *  matrix : a b
 *  word = "ab"
 *  
 *          root      j = 0       
 *       a            j = 1
 *     b -> word=ab   j =2         
 *   
 *   if j<=m is checked at first line then it will return and word checking condition
 *   will never hit
 *   
 *   so do something like this
 *   
 *  j=0         a
 *  j=1         b
 *  
 *  How trie reduces complexity
 *  
 *  a   a   a
 *  a   a   a       "aaaaaaaaaa","abcd","aaaabcd"
 *  a   a   a
 *  
 *  In normal case, we have to traverse all 3 words to check if its first char
 *  is matching a i,j cell but with trie in can find that in O(1)
 * 
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

class TrieNode
{
    TrieNode next[] = new TrieNode[26];
    String word;
}

public class WordSeachII
{   
    public static TrieNode build_trie(String words[])
    {
        TrieNode root = new TrieNode();
        
        for(int i=0;i<words.length;i++)
        {
            TrieNode iter = root;
            String word = words[i];
            
            for(int j=0;j<words[i].length();j++)
            {
                int    c    = word.charAt(j)-'a';
                if(iter.next[c]==null)
                {
                    iter.next[c] = new TrieNode();
                }
                iter = iter.next[c];
            }
            iter.word = word;
        }
        return root;
    }
    public static void is_word_exist(char[][] board,int i,int j,TrieNode root,List<String> res)
    {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return ;
        
        char temp = board[i][j];
        int c = temp-'a';
        
        if(temp=='*' || root.next[c]==null) return;
        
        root = root.next[c];    // solution to above problem
        
        if(root.word!=null)
        {
            res.add(root.word);
            // make it null bcs TC = "oath","oathify" but having different starting cells
            // when it crosses oath from the starting cell of oathify, if not make null,
            //will add oath to list again
            root.word = null;
           
           // here no return statement should be there bcs
           // TC = "oath","oathify"
           // after checking for oath, it should go to oathify also bcs same prefix is there
           // in trie approach, we don't again iterate over another words. So if we dont iterate
           // over oathify now, it will be skipped
            
           // also suppose from starting cell of oath, oath will be visited as well as
           // oathify bcs we are not returning
           // but actually starting cell of oath and oathify are different. So from cell
           // of oathify, trie will again be traversed but since it will not find any
           // word bcs of null, it will not add to list
        }
        
        // mark cell visited for current word
        board[i][j] = '*';
        
        // right
        is_word_exist(board,i,j+1,root,res);
        
        //down 
        is_word_exist(board,i+1,j,root,res);
        
        //left
        is_word_exist(board,i,j-1,root,res);
        
        //up
        is_word_exist(board,i-1,j,root,res);
        
        
        // backtrack so that cell can be marked unvisited for next word(one letter can
        // be used multiple times or iteration in same word
        board[i][j] = temp;
        
    }
    public static List<String> findWords(char[][] board, String[] words)
    {
        List<String> res = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;
        
        TrieNode root = build_trie(words);
       
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                is_word_exist(board,i,j,root,res);
            }
            
        }
        
        return res;
    }
    public static void main(String[] args) {
        char board[][] = {{'a','b'}};
        String words[] = {"ab"};
        
        System.out.println(findWords(board,words));

    }

}
