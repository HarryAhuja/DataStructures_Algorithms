package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

class node
{
    int i;
    int j;
    
    node(int x,int y)
    {
        this.i = x;
        this.j= y;
    }
    node()
    {
        i = 0;
        j = 0;
    }
   
}

/*
 * {1,1,1,1,1},
 * {1,0,0,0,1},
 * {1,0,1,0,1},
 * {1,0,0,0,1},
 * {1,1,1,1,1}
 */
public class ShortestBridge {
    
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    
    public static boolean isSafe(int x,int y,int n,boolean visited[][])
    {
        if(x>=n || x<0 || y>=n || y<0 || visited[x][y]==true)  return false;
        return true;
    }
    
    public static void dfs(int i,int j, int n, int mat[][],Queue<node> q,boolean visited[][])
    {
        visited[i][j] = true;
        q.offer(new node(i,j));
        
        for(int k=0;k<4;k++)
        {
            int new_i = i+dir[k][0];
            int new_j = j+dir[k][1];
        
            if(isSafe(new_i,new_j,n,visited) && mat[new_i][new_j]!=0)
            {
                dfs(new_i,new_j,n,mat,q,visited);
            }
        }
    }
    
    public static int minDistance(int mat[][])
    {
        int n = mat.length;
        boolean visited[][] = new boolean[n][n];
        
        Queue<node> q = new ArrayDeque<>();
        
        boolean flag = true;
        for(int i=0;i<n && flag;i++)
        {
            for(int j=0;j<n && flag;j++)
            {
                if(mat[i][j]==1)
                {
                    dfs(i,j,n,mat,q,visited);
                    flag = false;
                }
            }
        }
        
        int level = 0;
        
        while(q.size()>0)
        {
            int size = q.size();
            
            while(size>0)
            {
                node front = q.poll();
                
                for(int k=0;k<4;k++)
                {
                    int new_i = front.i+dir[k][0];
                    int new_j = front.j+dir[k][1];
                    
                    if(isSafe(new_i,new_j,n,visited)==false)    continue;
                    
                    if(mat[new_i][new_j]==1)    return level;
                
                    q.offer(new node(new_i,new_j));
                    visited[new_i][new_j] = true;
                }
                size--;
            }
            level++;
        }
        
        
        return -1;
    }
    public static void main(String[] args) {
        int mat[][] = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        
        System.out.println(minDistance(mat));

    }

}
