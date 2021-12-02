package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class GenerateBinaryStringofLengthN {

    public static void generate_strings_helper(char db[],int i,int n)
    {
        if(i==n)
        {
            for(int j=0;j<n;j++)    System.out.print(db[j]+" ");
            System.out.println();
            return;
        }
        
        db[i] = '0';
        generate_strings_helper(db,i+1,n);
        
        db[i] = '1';
        generate_strings_helper(db,i+1,n);
    }
    public static void generate_strings(int n)
    {
        char db[] = new char[n];
        
        generate_strings_helper(db,0,n);
    }
    public static void main(String[] args) {
        
        int n = 3;
        generate_strings(n);
        

    }

}
