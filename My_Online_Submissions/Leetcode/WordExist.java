package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class WordExist {

    public static boolean is_safe(char board[][], int row,int col,boolean visited[][])
    {
        if(row>=board.length || row<0 || col>=board[0].length || col<0 || visited[row][col]==true)
            return false;

        return true;
    }
    public static boolean is_word_exist(char board[][], String target, int row,int col,int index,
                                        boolean visited[][])
    {
        if(index == target.length())
        {
            return true;
        }
        
        if(is_safe(board,row,col,visited)==false)
            return false;
        
        // return if consecutive position is not matched
        if((target.charAt(index) != board[row][col]))   return false;
        
        // This is for cyclic dependency check
        visited[row][col] = true;
        index++;
        
        // right
        if(is_word_exist(board,target,row,col+1,index,visited)==true)   return true;
        
        //down 
        if(is_word_exist(board,target,row+1,col,index,visited)==true)   return true;
        
        //left
        if(is_word_exist(board,target,row,col-1,index,visited)==true)   return true;
        
        //up
        if(is_word_exist(board,target,row-1,col,index,visited)==true)   return true;
        
        
        // index-- not needed as automatically
        // done(pass by value)
        visited[row][col] = false;
        
        return false;
    }
    public static boolean is_word_exist(char board[][], String target)
    {
        int len = target.length();
        if(len == 0)    return false;
        
        boolean visited[][] = new boolean[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==target.charAt(0))
                {
                    if(is_word_exist(board,target,i,j,0,visited)==true)
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
