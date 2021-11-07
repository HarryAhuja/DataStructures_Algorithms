package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class GameOfLife {
    
    static final int vertical_direction[]   = {0,1,1,1,0,-1,-1,-1};
    static final int horizontal_direction[] = {1,1,0,-1,-1,-1,0,1};
    
    
    public static void gameOfLife(int[][] board)
    {
        int n = board.length;
        int m = board[0].length;
        
        int next[][] = new int[n][m];
        
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int live_counts = 0;
                
                for(int dir=0;dir<8;dir++)
                {
                    int new_i = i+vertical_direction[dir];
                    int new_j = j+horizontal_direction[dir];
                    
                    if(new_i>=0 && new_i<n && new_j>=0 && new_j<m && board[new_i][new_j]==1)
                        live_counts++;
                }
                
                // Rest of the cases will be handled by default zero values in next
                if(board[i][j] == 0 && live_counts==3)
                {
                    next[i][j] = 1;
                }
                else if(board[i][j] == 1 &&
                        ((live_counts==3) || (live_counts==2))
                        )
                {
                    next[i][j] = 1;
                }
                    
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                board[i][j] = next[i][j];
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
