/*
 *  Using three hashSet for row,col,sub_box
 *  
 *  For row set, we want to reset it after each row
 *  so we use [r][c]
 *  
 *  For col set, we want to reset it after each col
 *  so we use [c][r]
 *  
 *  suppose window size is 3*3
 *  
 *  so divide the whole grid into these sub blocks
 *  each sub block will have its row index and col index(just like each cell within sub)
 *  
 *  To get row_index of sub_block(not cell)-> r/3
 *  To get col_index of sub_block(not cell)-> c/3
 *  
 *  Now we get to sub-block
 *  Now within sub-block, there are 3 rows and 3 cols
 *  to get row_of_cell_within_sub_block = r%3
 *  to get col_of_cell_within_sub_block = c%3
 *  
 *  So with this approach each sub-box will be identifed by sub_box_row, sub_box_col
 *  
 *  2nd approach
 *  
 *  Each sub box from L to R and then vertical will start its indexing from 0
 *  
 *  See copy
 *  
 *  one of the solution can be , in 9*9 grid, there are 9 sub boxes of 3*3 size
 *  so we can have array 9 hashsets, and depending upon the sub_box index,
 *  we can add and check in one of the 9 hashset
 *  
 *  or in java, instead of array of 9 hashset, hashmap where key represents
 *  sub_block_number(or row and col index of sub_block) and value represents
 *  hash set for that sub_block
 *  
 *  In this question, r and c have different meaning for row, col and subbox
 *  So calculation is done in that way
 *  
 */
package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.HashSet;

public class ValidSoduko
{
    final static int max_rows = 9;
    final static int max_cols = 9;
   
    public boolean isValidSudoku(char[][] board)
    {
        HashSet<Character> row_set = new HashSet<Character>();
        HashSet<Character> col_set = new HashSet<Character>();
        HashSet<Character> box_set = new HashSet<Character>();
        
        
        for(int r=0;r<max_rows;r++)
        {
            row_set.clear();    // for each row, check independently
            col_set.clear();    // for each col, check independently
            box_set.clear();    // for each sub block, check independently
            
            // Box set is also cleared here bcs r represents index of sub block
            // from 0 to 8. So at each new sub_box, its cleared
            
            for(int c=0;c<max_cols;c++)
            {
                // [r][c] for row wise 
                if(board[r][c]!='.' && row_set.add(board[r][c])==false)   return false;
                
                // [c][r] for row wise 
                if(board[c][r]!='.' && col_set.add(board[c][r])==false)   return false;
                
                // Here c for sub-block represents all cells within that sub-block
                // Here r represents sub-block number
                // r/3 gives in which sub_block_row_index it will fall
                // c/3 will give within that sub_block, in which row it will fall
                // c/3 is done for row bcs second row after first row falls after
                // skipping 3 cells in horizontal direction
                // c%3 for col is done bcs of vertical direction
                
                /*
                 * See it as
                 *  0   1   2
                 *  3   4   5
                 *  6   7   8
                 */
                
                int actual_row_index = 3*(r/3) +(c/3);
                
                
                /*
                 * See it as
                 *  0   3   5
                 *  1   4   6
                 *  2   5   7
                 */
                
                int actual_col_index = 3*(r/3) +(c%3);
                
                if(board[actual_row_index][actual_col_index]!='.' &&
                  !box_set.add(board[actual_row_index][actual_col_index]))
                {
                    return false;
                }
                
            }
        }
        return true;
    }
}
