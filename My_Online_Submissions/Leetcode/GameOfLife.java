/*
 * 0  -> dead to dead
 * 1  -> live to live
 * 2  -> dead to live
 * 3  -> live to dead
 * 
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class GameOfLife {
    
    static final int vertical_direction[]   = {0,1,1,1,0,-1,-1,-1};
    static final int horizontal_direction[] = {1,1,0,-1,-1,-1,0,1};
    
    
    public static void gameOfLife(int[][] board)
    {
        int n = board.length;
        int m = board[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int live_counts = 0;
                
                for(int dir=0;dir<8;dir++)
                {
                    int new_i = i+vertical_direction[dir];
                    int new_j = j+horizontal_direction[dir];
                    
                    // check original state. 1 and 3 means they were
                    // originally alive
                    if(new_i>=0 && new_i<n && new_j>=0 && new_j<m &&
                       (board[new_i][new_j]==1 || board[new_i][new_j]==3)
                       )
                        live_counts++;
                }
                
                // Make cell dead->alive
                if(board[i][j] == 0 && live_counts==3)
                {
                    board[i][j] = 2;
                }
                // Keep it alive
                else if(board[i][j] == 1 &&
                        ((live_counts==3) || (live_counts==2))
                        )
                {
                    // Do nothing
                    // keep same state
                    //board[i][j] = 1;
                }
                // make live -> dead cell
                else if(board[i][j] == 1)
                    board[i][j] = 3;
                    
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                switch(board[i][j])
                {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        board[i][j] = 1;
                        break;
                    case 3:
                        board[i][j] = 0;
                        break; 
                }
            }
        }
    }
    public static void main(String[] args) {
        
        int board[][] = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        
        gameOfLife(board);
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }

}
