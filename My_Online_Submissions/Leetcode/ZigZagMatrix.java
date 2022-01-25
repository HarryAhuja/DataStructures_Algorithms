package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

/*
 * Matrix is n*m
 * 
 * i<m-1: no of elements will increase from 1 to m-1: total diagonals are m-1
 * i>m-1 and i<n: no of elements will be n: total diagonals are (n-1)-(m-1)+1 = n-m+1
 * i>=n: no of elements will decrease from m-1 to 1: total diagonals are m-1
 * 
 * Total diagonals = n+m-1
 * 
 */

public class ZigZagMatrix {

    static void printMatrix(int matrix[][])
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.print("\n");
        }
    }
    public static void diagonalOrder(int matrix[][])
    {
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int d=1;d<=(n+m-1);d++)
        {
            // For d=1 to n, start col is 0 and then it is d-n
            int start_col = Math.max(0, d-n);
            
            int count = 0;
            
            if(d<=(m-1))  count = d;
            else if(d<n)  count = m;
            else          count = (n+m-d);
            
            for(int no_of_elements=0;no_of_elements<count;no_of_elements++)
            {
                System.out.print(matrix[(Math.min(d-1,n-1))-(no_of_elements)][start_col+no_of_elements]+" ");
            } 
            System.out.println();
        }
        
        
        
    }
    public static void main(String[] args) {
        int M[][] = {
                { 1, 2, 3, 4 },     { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },  { 13, 14, 15, 16 },
                { 17, 18, 19, 20 },
            };
            System.out.print("Given matrix is \n");
            printMatrix(M);
     
            System.out.print(
                "\nDiagonal printing of matrix is \n");
            diagonalOrder(M);

    }

}
