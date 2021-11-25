/*
 * Minimum number of minutes means we have to find the min time in which rotten oranges
 * rotten the farthest fresh orange
 * 
 *                   |
 *           |   last_fresh |
 *                   |
 * This last fresh orange can be rottened from 4 directions at different time(depending 
 * upon path) but we need minimum time(like fastest fire path)
 * 
 * Also TC can be , all fresh oranges can't be rotten. Fresh orange don't have connected
 * path with other fresh oranges+atleast one rotten
 * 
 * How to check if any fresh orange is left or not in last
 * 1.) count total fresh oranges at first
 * 2.) keep counting fresh oranges those got rotten
 * 3.) check if they are equal or not
 * 
 * TC, there can be multiple connected components that can be rotten
 * 
 * 2    1   0
 * 0    1   0   
 * 0    0   0
 * 0    2   1
 * 0    1   0
 * 
 * What will be the answer of this?
 * 
 * ans =  2
 * 
 * In first minute, upper 2 rottened 1 orange and lower 2 rottened two oranges
 * in second minute, upper 2(prev rottened) rotten 1 more orange
 * 
 * Therefore put all rotten positions in queue
 * 
 * Make visited true while putting it in queue not while popping out in bfs
 * 
 * 2    1
 * 1    1*
 * 
 * 1* will be pushed twice if not set to true while pushing bcs below 1 will also
 * push it into the queue bcs its value is not set to false by upper 1 bcs its not
 * visited yet
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

class MatrixNode
{
    int x;
    int y;
    
    
    public MatrixNode()
    {
        x = y = -1;
    }
    public MatrixNode(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}

public class RottenOranges {
    
    public static int orangesRotting(int[][] grid)
    {
        /*
         *  0 representing an empty cell,
         *  1 representing a fresh orange, or
         *  2 representing a rotten orange.
         * 
         */
        int m = grid.length;
        int n = grid[0].length;
        
        if(m==0 && n==0)    return -1;
        
        boolean visited[][] = new boolean[m][n];
        Queue<MatrixNode> q = new ArrayDeque<MatrixNode>();
        
        int fresh_oranges = 0;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)       q.offer(new MatrixNode(i,j));
                else if(grid[i][j]==1)  fresh_oranges++;
            }
            
        }
        
        // if no fresh oranges, then no minute takes to rotten it
        if(fresh_oranges==0)    return 0;
       
        int ans = 0;
        while(q.isEmpty()==false)
        {
            int size = q.size();    // Number of rotten oranges at that minute
            ans++;
            
            // ans is outside for loop bcs in that particular minute, all rotten oranges
            // will rotten their fresh oranges parallely note serially, After loop ends
            // queue will have next set of rotten oranges for next minute
            for(int i=0;i<size;i++)
            {
                MatrixNode front = q.poll();
                 
                // right side
                if(front.y+1<n && visited[front.x][front.y+1]==false && grid[front.x][front.y+1]==1)
                {
                    q.add(new MatrixNode(front.x,front.y+1));
                    visited[front.x][front.y+1] = true;
                    fresh_oranges--;
                }
                
                // down side
                if(front.x+1<m && visited[front.x+1][front.y]==false &&  grid[front.x+1][front.y]==1)
                {
                    q.add(new MatrixNode(front.x+1,front.y));
                    visited[front.x+1][front.y] = true;
                    fresh_oranges--;
                }
                
                // left side
                if(front.y-1>=0 && visited[front.x][front.y-1]==false && grid[front.x][front.y-1]==1)
                {
                    q.add(new MatrixNode(front.x,front.y-1));
                    visited[front.x][front.y-1] = true;
                    fresh_oranges--;
                }
                
                // above side
                if(front.x-1>=0 && visited[front.x-1][front.y]==false && grid[front.x-1][front.y]==1)
                {
                    q.add(new MatrixNode(front.x-1,front.y));
                    visited[front.x-1][front.y] = true;
                    fresh_oranges--;
                }
            }

        }
       
        if(fresh_oranges==0)    return ans-1;   // ans++ is also done from start of first 2(rotten)
        else                    return -1;
    }
    public static void main(String[] args) {
        int grid[][] = {{2,1,0},{1,0,0},{0,0,0},{0,2,1},{0,1,0}};
        System.out.println(orangesRotting(grid));
    }

}
