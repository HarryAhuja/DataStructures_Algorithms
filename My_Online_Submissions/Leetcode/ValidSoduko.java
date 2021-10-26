/*
 *  For finding any unique values, always use hashSet bcs lookup is O(1)
 *  
 *  set.add() returns false if element is present
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashSet;

public class ValidSoduko
{
    final static int max_rows = 9;
    final static int max_cols = 9;
    
    public boolean isValidSudoku(char[][] board)
    {
        HashSet<String> set = new HashSet<String>();
        
        for(int r=0;r<max_rows;r++)
        {
            for(int c=0;c<max_cols;c++)
            {
                char curr = board[r][c];
                
                if(curr == '.') continue;
                
                if((set.add(curr+" found in row "+r)==false) ||
                   (set.add(curr+" found in col "+c)==false) ||
                   (set.add(curr+" found in sub_box "+r/3+"-"+c/3)==false))
                    return false;
            }
        }
        return true;
    }
}
