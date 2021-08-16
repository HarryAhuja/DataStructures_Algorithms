/*
 * Challenges
 * 1.) start search from all locations that matches with first char
 * 2.) once the search starts, search consecutive letters and return
 *     false if any of the 4 letters don't match
 * 3.) 1 and 2 are contradictions if we combine both of them
 *    and bcs 1 say if letter doesn't match search in 4 directions to
 *    find first matching letter whereas 2 says once search starts
 *    it should be consecutive letters
 *     
 * Initial runtime = 292ms
 * current runtime = 92ms
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class WordExist {

    public static boolean is_safe(char board[][], int row,int col)
    {
        if(row>=board.length || row<0 || col>=board[0].length || col<0)
            return false;

        return true;
    }
    public static boolean is_word_exist(char board[][], String target, int row,int col,int index)
    {
        if(index == target.length())
        {
            return true;
        }
        
        if(is_safe(board,row,col)==false)
            return false;
        
        // return if consecutive position is not matched
        // can move to is_safe()
        if((target.charAt(index) != board[row][col]))   return false;
        
        // This is for cyclic dependency check
        board[row][col] = '*';
        
        /*
        boolean result = is_word_exist(board,target,row,col+1,index+1) ||
                        is_word_exist(board,target,row+1,col,index+1)  ||
                        is_word_exist(board,target,row,col-1,index+1)  ||
                        is_word_exist(board,target,row-1,col,index+1);
        */
        
        // right
        if(is_word_exist(board,target,row,col+1,index+1)==true)   return true;
        
        //down 
        if(is_word_exist(board,target,row+1,col,index+1)==true)   return true;
        
        //left
        if(is_word_exist(board,target,row,col-1,index+1)==true)   return true;
        
        //up
        if(is_word_exist(board,target,row-1,col,index+1)==true)   return true;
        
        
        // index-- not needed as automatically
        // done(pass by value)
        board[row][col] = target.charAt(index);
        
        return false;
    }
    public static boolean is_word_exist(char board[][], String target)
    {
        int len = target.length();
        if(len == 0)    return false;
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==target.charAt(0))
                {
                    if(is_word_exist(board,target,i,j,0)==true)
                        return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
        
        
        char board[][] = {{'A','B','C','E'},{'S','F','C','F'},{'A','D','E','E'}};
        String word = "SEE";
        
        System.out.println(is_word_exist(board,word));

    }

}
