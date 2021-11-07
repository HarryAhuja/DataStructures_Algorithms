package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class SurrounderRegions {
    public static void numIslandsHelper(char[][] grid,int i, int j,int n,int m, boolean visited[][])
    {
        if(i>=n || i<0 || j>=m || j<0 || grid[i][j]=='0' || visited[i][j]==true)
            return;
        
        visited[i][j] = true;
        
        numIslandsHelper(grid, i, j+1, n, m, visited);
        numIslandsHelper(grid, i+1,j, n, m, visited);
        numIslandsHelper(grid, i, j-1, n, m, visited);
        numIslandsHelper(grid, i-1, j, n, m, visited);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
