/*
 *  Same letter can't be used in same word multiple time
 *  but same letter can be used in two different words
 *  
 *  index should be local not global
 *  
 *  Ex
 *      (at this a) , when false comes from right bcs h is not there after t, then
 *      index should come back to t to search downwards. It should not retain on h
 *      
 *  o   a   t   n   
 *  e   t   a   e
 *  i   h   k   r
 *  
 *  word = oath
 *  
 *  Two problems in this approach
 *  1.) once one word is found, we have to flag it done and don't search for in another cells
 *     Bcs word.length can be 10^4. So tc would increase
 *  2.) if any word is found then it will return true and will not set back original char
 *      in input matrix(no backtracking, return true earlier)
 *      So while finding next word, input is changed-> Solution: use copy matrix
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSeachII {
   
    public static void copy(char board[][], char copy[][],int rows,int cols)
    {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                copy[i][j] = board[i][j];
            }
        }
    }
    public static boolean is_word_exist(char[][] board, String word,int i,int j,int index)
    {
        if(index == word.length())  return true;
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        

        if(word.charAt(index)!=board[i][j]) return false;
        
        // mark cell visited for current word
        board[i][j] = '*';
        
        // right
        if(is_word_exist(board,word,i,j+1,index+1)==true)   return true;
        
        //down 
        if(is_word_exist(board,word,i+1,j,index+1)==true)   return true;
        
        //left
        if(is_word_exist(board,word,i,j-1,index+1)==true)   return true;
        
        //up
        if(is_word_exist(board,word,i-1,j,index+1)==true)   return true;
        
        
        // backtrack so that cell can be marked unvisited for next word(one letter can
        // be used multiple times or iteration in same word
        board[i][j] = word.charAt(index);
        
        return false;
    }
    public static List<String> findWords(char[][] board, String[] words)
    {
        List<String> res = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;
        
        char[][] board_copy = new char[rows][cols];
        copy(board,board_copy,rows,cols);
        
        int n = words.length;
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                for(int w=0;w<n;w++)
                {
                    if(board[i][j] == words[w].charAt(0))
                    {
                        
                        boolean ans = is_word_exist(board_copy,words[w],i,j,0);
                        if(ans==true)
                        {
                            // don't break here
                            // multiple words can start from same start letter
                            // But once one word is found, no need to search again at other
                            // cells
                            copy(board,board_copy,rows,cols);
                            res.add(words[w]);
                        }
                    }
                }
            }
            
        }
        
        return res;
    }
    public static void main(String[] args) {
        char board[][] = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},
                          {'i','f','l','v'}};
        String words[] = {"oath","pea","eat","rain"};
        
        System.out.println(findWords(board,words));

    }

}
